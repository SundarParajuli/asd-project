package creditcard;




import framework.observer.EmailSender;
import creditcard.paymentCalculationStrategy.BronzePaymentCalculationStrategy;
import creditcard.paymentCalculationStrategy.GoldPaymentCalculationStrategy;
import creditcard.paymentCalculationStrategy.SilverPaymentCalculationStrategy;
import framework.entity.Account;
import framework.entity.AccountService;
import framework.entity.Customer;
import framework.observer.SMSSender;

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
        String billstring = "";
        LocalDate todaydate = LocalDate.now();
        for (Account account: getAllAccounts()) {
            Customer cust = account.getCustomer();
            CreditAccount act = (CreditAccount) account;
            double prevBalance = act.getPrevBalance();
            double totalCredit = act.getTotalCredit();
            double totalCharge = act.getTotalCharge();
            double newBalance = act.getNewBalance();
            double totalDue = act.getTotalDue();
            billstring += String.format("Name= %s\r\n", cust.getName());
            billstring += String.format("Address= %s, %s, %s, %s\r\n", cust.getStreet(), cust.getCity(), cust.getState(), cust.getZip());
            billstring += String.format("CC number= %s\r\n", account.getAccountNumber());
            billstring += String.format("CC type= %s\r\n", account.getAccountType());
            billstring += String.format("Previous balance = $ %f\r\n", prevBalance);
            billstring += String.format("Total Credits = $ %f\r\n", totalCredit);
            billstring += String.format("Total Charges = $ %f\r\n", totalCharge);
            billstring += String.format("New balance = $ %f\r\n", newBalance);
            billstring += String.format("Total amount due = $ %f\r\n", totalDue);
            billstring += "\r\n";
            billstring += "\r\n";
        }
        setReport(billstring);
        notifyObservers("report");
    }
}
