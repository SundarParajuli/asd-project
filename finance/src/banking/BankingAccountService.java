package banking;

import banking.interestCalculators.CompanyCheckingInterestCalculator;
import banking.interestCalculators.CompanySavingInterestCalculator;
import banking.interestCalculators.PersonalCheckingInterestCalculator;
import banking.interestCalculators.PersonalSavingInterestCalculator;
import framework.entity.Account;
import framework.entity.AccountService;
import framework.entity.Customer;
import framework.entity.Personal;
import framework.observer.EmailSender;

public class BankingAccountService extends AccountService {
    private static volatile BankingAccountService instance;

    private BankingAccountService() {
        super(BankingAccountDAO.getInstance());
        this.registerObserver(new EmailSender(this));
    }

    @Override
    public Account initAccount(String accountType, Customer customer) {
        if (customer instanceof Personal) {
            if (AccountTypes.valueOf(accountType) == AccountTypes.Checking) {
                return new CheckingAccount(new PersonalCheckingInterestCalculator());
            }
            return new SavingAccount(new PersonalSavingInterestCalculator());
        }
        if (AccountTypes.valueOf(accountType) == AccountTypes.Checking) {
            return new CheckingAccount(new CompanyCheckingInterestCalculator());
        }
        return new SavingAccount(new CompanySavingInterestCalculator());
    }

    public static BankingAccountService getInstance() {
        if (instance == null) {
            synchronized (BankingAccountService.class) {
                if (instance == null) {
                    instance = new BankingAccountService();
                }
            }
        }
        return instance;
    }
}
