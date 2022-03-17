package framework.observer;

import framework.entity.Account;
import framework.entity.AccountObserver;
import framework.entity.AccountService;

public abstract class Sender implements AccountObserver {
    private AccountService accountService;

    public Sender(AccountService accountService) {
        this.accountService = accountService;
    }

    public AccountService getAccountService() {
        return accountService;
    }

    public Account getAccount() {
        return accountService.getChangedAccount();
    }

    public double getAmount() {
        double amount = accountService.getChangedAmount();
        if(amount < 0){
            amount = -amount;
        }
        return amount;
    }
}
