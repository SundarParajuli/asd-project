package creditcard;


import creditcard.interestCalculatorStrategy.BronzeInterestStrategy;
import creditcard.interestCalculatorStrategy.GoldInterestStrategy;
import creditcard.interestCalculatorStrategy.SilverInterestStrategy;
import creditcard.paymentCalculationStrategy.BronzePaymentCalculationStrategy;
import creditcard.paymentCalculationStrategy.GoldPaymentCalculationStrategy;
import creditcard.paymentCalculationStrategy.SilverPaymentCalculationStrategy;
import framework.entity.Account;
import framework.entity.AccountService;
import framework.entity.Customer;
import framework.observer.BankingEmailSender;
import framework.observer.BankingSMSSender;
import framework.observer.CreditEmailSender;
import framework.observer.CreditSMSSender;
import framework.visitor.ReportBuilderVisitor;



public class CreditAccountService extends AccountService {
    private static volatile CreditAccountService instance;

    private CreditAccountService() {
        super(CreditAccountDAO.getINSTANCE());
        this.registerObserver(new CreditEmailSender(this));
        this.registerObserver(new CreditSMSSender(this));
    }

    public static CreditAccountService getInstance() {
        if (instance == null) {
            synchronized (CreditAccountService.class) {
                if (instance == null) {
                    instance = new CreditAccountService();
                }
            }
        }
        return instance;
    }

    @Override
    public void deposit(String accountNumber, double amount) {
        super.withdraw(accountNumber, -amount);
    }

    @Override
    public void withdraw(String accountNumber, double amount) {
        super.deposit(accountNumber, amount);
    }

    @Override
    public Account createAccount(String accountType, Customer customer) {
        CreditCardType type = CreditCardType.valueOf(accountType);
        if (type.equals(CreditCardType.BRONZE)) {
            return new CreditAccount(new BronzePaymentCalculationStrategy(), type, new BronzeInterestStrategy());
        }
        if (type.equals(CreditCardType.SILVER)) {
            return new CreditAccount(new SilverPaymentCalculationStrategy(), type, new SilverInterestStrategy());
        }
        if (type.equals(CreditCardType.GOLD)) {
            return new CreditAccount(new GoldPaymentCalculationStrategy(), type, new GoldInterestStrategy());
        }
        throw new UnsupportedOperationException("Invalid Credit Card Type!");
    }

    @Override
    public void buildReport() {
        ReportBuilderVisitor reportBuilderVisitor = new ReportBuilderVisitor("CreditCard");
        for (Account account : getAllAccounts()) {
            account.accept(reportBuilderVisitor);
        }
        setReport(reportBuilderVisitor.getReport());
        notifyObservers("report");
    }
}
