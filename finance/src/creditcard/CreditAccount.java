package creditcard;


import creditcard.paymentCalculationStrategy.PaymentCalculationStrategy;
import framework.entity.Account;
import framework.entity.AccountEntry;

import java.time.LocalDate;

public class CreditAccount extends Account {
    PaymentCalculationStrategy paymentCalculationStrategy;
    CreditCardType creditCardType;
    public CreditAccount(PaymentCalculationStrategy paymentCalculationStrategy, CreditCardType creditCardType) {
        super(null);
        this.paymentCalculationStrategy = paymentCalculationStrategy;
        this.creditCardType = creditCardType;
    }

    public double getPrevBalance() {
        LocalDate currentDate = LocalDate.now();
        return this.getAccountEntries().stream()
                .filter(accountEntry -> accountEntry.getDate().isBefore(currentDate.withDayOfMonth(1)))
                .mapToDouble(AccountEntry::getAmount).sum();
    }

    public double getTotalCredit() {
        LocalDate currentDate = LocalDate.now();
        return this.getAccountEntries().stream()
                .filter(accountEntry -> accountEntry.getDate().isAfter(currentDate.withDayOfMonth(1)))
                .filter(accountEntry -> accountEntry.getAmount() < 0)
                .mapToDouble(AccountEntry::getAmount).sum();
    }

    public double getTotalCharge() {
        LocalDate currentDate = LocalDate.now();
        return this.getAccountEntries().stream()
                .filter(accountEntry -> accountEntry.getDate().isAfter(currentDate.withDayOfMonth(1)))
                .filter(accountEntry -> accountEntry.getAmount() >= 0)
                .mapToDouble(AccountEntry::getAmount).sum();
    }

    public double getNewBalance() {
        return this.paymentCalculationStrategy.calculateBalance(getPrevBalance(), getTotalCredit(), getTotalCharge());
    }

    public double getTotalDue() {
        return this.paymentCalculationStrategy.calculateDuePayment(getNewBalance());
    }

    @Override
    public String getAccountType() {
        return creditCardType.name();
    }
}
