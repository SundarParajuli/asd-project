package creditcard;




import framework.observer.EmailSender;
import creditcard.paymentCalculationStrategy.BronzePaymentCalculationStrategy;
import creditcard.paymentCalculationStrategy.GoldPaymentCalculationStrategy;
import creditcard.paymentCalculationStrategy.SilverPaymentCalculationStrategy;
import framework.entity.Account;
import framework.entity.AccountService;
import framework.entity.Customer;
import framework.observer.SMSSender;
import framework.visitor.ReportBuilderVisitor;

import java.time.LocalDate;


public class CreditAccountService extends AccountService {
    private static volatile  CreditAccountService instance;

    private CreditAccountService() {
        super(CreditAccountDAO.getINSTANCE());
        this.registerObserver(new EmailSender(this));
        this.registerObserver(new SMSSender(this));
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
        super.withdraw(accountNumber, amount);
    }

    @Override
    public Account initAccount(String accountType, Customer customer) {
        CreditCardType type = CreditCardType.valueOf(accountType);
        if(type.equals(CreditCardType.BRONZE)){
            return new CreditAccount(new BronzePaymentCalculationStrategy(), type);
        }
        if(type.equals(CreditCardType.SILVER)){
            return new CreditAccount(new SilverPaymentCalculationStrategy(), type);
        }
        if(type.equals(CreditCardType.GOLD)){
            return new CreditAccount(new GoldPaymentCalculationStrategy(), type);
        }
        throw new UnsupportedOperationException("Invalid Credit Card Type!");
    }

    @Override
    public void buildReport() {
        ReportBuilderVisitor reportBuilderVisitor = new ReportBuilderVisitor("CreditCard");
        for (Account account: getAllAccounts()) {
            account.accept(reportBuilderVisitor);
        }
        setReport(reportBuilderVisitor.getReport());
        notifyObservers("report");
    }
}
