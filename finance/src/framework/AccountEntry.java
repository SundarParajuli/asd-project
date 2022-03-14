package framework;

import java.time.LocalDate;

public class AccountEntry {
    private LocalDate date;
    private double amount;
    private String description;
    private Account fromAccount;

    public AccountEntry(double amount, String description, Account fromAccount) {
        this.date = LocalDate.now();
        this.amount = amount;
        this.description = description;
        this.fromAccount = fromAccount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Account getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(Account fromAccount) {
        this.fromAccount = fromAccount;
    }
}
