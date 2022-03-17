package framework.entity;

import java.time.LocalDate;

public class AccountEntry {
    private LocalDate date;
    private double amount;
    private String description;

    public AccountEntry(double amount, String description) {
        this.date = LocalDate.now();
        this.amount = amount;
        this.description = description;
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

}
