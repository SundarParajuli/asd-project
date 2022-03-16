package banking;

import banking.interestCalculationStrategy.CompanyCheckingInterestStrategy;
import banking.interestCalculationStrategy.CompanySavingInterestStrategy;
import banking.interestCalculationStrategy.PersonalCheckingInterestStrategy;
import banking.interestCalculationStrategy.PersonalSavingInterestStrategy;
import creditcard.CreditAccount;
import framework.entity.Account;
import framework.entity.AccountService;
import framework.entity.Customer;
import framework.entity.Personal;
import framework.observer.EmailSender;
import framework.observer.SMSSender;
import framework.visitor.ReportBuilderVisitor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BankingAccountService extends AccountService {
    private static volatile BankingAccountService instance;

    private BankingAccountService() {
        super(BankingAccountDAO.getINSTANCE());
        this.registerObserver(new EmailSender(this));
        this.registerObserver(new SMSSender(this));
    }

    @Override
    public Account createAccount(String accountType, Customer customer) {
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

    @Override
    public void deposit(String accountNumber, double amount) {
        super.deposit(accountNumber, amount);
    }

    @Override
    public void withdraw(String accountNumber, double amount) {
        super.withdraw(accountNumber, -amount);
    }

    @Override
    public void buildReport() {
        ReportBuilderVisitor reportBuilderVisitor = new ReportBuilderVisitor("Banking");
        for (Account account: getAllAccounts()) {
            account.accept(reportBuilderVisitor);
        }
        setReport(reportBuilderVisitor.getReport());
        notifyObservers("report");
    }


}
