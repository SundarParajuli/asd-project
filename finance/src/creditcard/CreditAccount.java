package creditcard;


import creditcard.paymentCalculators.PaymentCalculator;
import framework.Account;
import framework.AccountEntry;

import java.time.LocalDate;

public class CreditAccount extends Account {
    PaymentCalculator paymentCalculator;
    CreditCardType type;
    public CreditAccount(PaymentCalculator paymentCalculator, CreditCardType type) {
        super(null);
        this.paymentCalculator = paymentCalculator;
        this.type = type;
    }

    public double getPrevBalance() {
        LocalDate todaydate = LocalDate.now();
        return this.getAccountEntries().stream()
                .filter(accountEntry -> accountEntry.getDate().isBefore(todaydate.withDayOfMonth(1)))
                .mapToDouble(AccountEntry::getAmount).sum();
    }

    public double getTotalCredit() {
        LocalDate todaydate = LocalDate.now();
        return this.getAccountEntries().stream()
                .filter(accountEntry -> accountEntry.getDate().isAfter(todaydate.withDayOfMonth(1)))
                .filter(accountEntry -> accountEntry.getAmount() < 0)
                .mapToDouble(AccountEntry::getAmount).sum();
    }

    public double getTotalCharge() {
        LocalDate todaydate = LocalDate.now();
        return this.getAccountEntries().stream()
                .filter(accountEntry -> accountEntry.getDate().isAfter(todaydate.withDayOfMonth(1)))
                .filter(accountEntry -> accountEntry.getAmount() >= 0)
                .mapToDouble(AccountEntry::getAmount).sum();
    }

    public double getNewBalance() {
        return this.paymentCalculator.calculateBalance(getPrevBalance(), getTotalCredit(), getTotalCharge());
    }

    public double getTotalDue() {
        return this.paymentCalculator.calculateDuePayment(getNewBalance());
    }

    @Override
    public String getAccountType() {
        return type.name();
    }
}
