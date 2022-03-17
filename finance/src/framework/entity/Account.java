package framework.entity;

import framework.visitor.AccountVisitor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public abstract class Account implements Consumer<AccountVisitor> {
    private Customer customer;
    private String accountNumber;
    private List<AccountEntry> accountEntries;
    private InterestCalculationStrategy interestCalculationStrategy;

    public Account(InterestCalculationStrategy interestCalculationStrategy) {
        this.interestCalculationStrategy = interestCalculationStrategy;
        this.accountEntries = new ArrayList<>();
    }

    public void setInterestCalculationStrategy(InterestCalculationStrategy interestCalculationStrategy) {
        this.interestCalculationStrategy = interestCalculationStrategy;
    }

    public abstract String getAccountType();

    public double getBalance() {
        return accountEntries.stream().mapToDouble(AccountEntry::getAmount).sum();
    }

    public void deposit(double amount) {
        AccountEntry entry = new AccountEntry(amount, "deposit");
        addAccountEntry(entry);
    }

    public void withdraw(double amount) {
        AccountEntry entry = new AccountEntry(amount, "withdraw");
        addAccountEntry(entry);
    }

    public void addInterest() {
        if (interestCalculationStrategy != null) {
            double interest = interestCalculationStrategy.calculateInterest(getBalance());
            AccountEntry entry = new AccountEntry(interest, "interest");
            addAccountEntry(entry);
        }
        System.out.println(getAccountNumber() + "\t" +getBalance());
    }

    private void addAccountEntry(AccountEntry entry) {
        accountEntries.add(entry);
    }

    public Collection<AccountEntry> getAccountEntries() {
        return accountEntries;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return accountNumber.equals(account.accountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber);
    }
}
