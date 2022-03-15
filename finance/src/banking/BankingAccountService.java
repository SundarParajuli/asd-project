package banking;

import banking.interestCalculationStrategy.CompanyCheckingInterestStrategy;
import banking.interestCalculationStrategy.CompanySavingInterestStrategy;
import banking.interestCalculationStrategy.PersonalCheckingInterestStrategy;
import banking.interestCalculationStrategy.PersonalSavingInterestStrategy;
import framework.entity.Account;
import framework.entity.AccountService;
import framework.entity.Customer;
import framework.entity.Personal;
import framework.observer.EmailSender;
import framework.observer.SMSSender;

public class BankingAccountService extends AccountService {
    private static volatile BankingAccountService instance;

    private BankingAccountService() {
        super(BankingAccountDAO.getINSTANCE());
        this.registerObserver(new EmailSender(this));
        this.registerObserver(new SMSSender(this));
    }

    @Override
    public Account initAccount(String accountType, Customer customer) {
        if (customer instanceof Personal) {
            if (AccountType.valueOf(accountType) == AccountType.CHECKING) {
                return new CheckingAccount(new PersonalCheckingInterestStrategy());
            }
            return new SavingAccount(new PersonalSavingInterestStrategy());
        }
        if (AccountType.valueOf(accountType) == AccountType.CHECKING) {
            return new CheckingAccount(new CompanyCheckingInterestStrategy());
        }
        return new SavingAccount(new CompanySavingInterestStrategy());
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
