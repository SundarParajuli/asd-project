package framework.observer;


import banking.CheckingAccount;
import banking.SavingAccount;
import creditcard.CreditAccount;
import framework.entity.*;

public class EmailSender implements AccountObserver {
    private AccountService accountService;

    public EmailSender(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void update(String type) {
        Account account = accountService.getChangedAccount();
        if(account instanceof SavingAccount){

        }else if(account instanceof CheckingAccount){

        }else if(account instanceof CreditAccount){

        }
        if (type.equals("withdraw") || type.equals("deposit")) {

            double amount = accountService.getChangedAmount();
            if (account.getCustomer() instanceof Personal && (amount <= 500 && account.getBalance() > 0)) {
                return;
            }
            System.out.println("Sending email to: " + account.getCustomer().getEmail() + " Transaction in account (" + account.getAccountNumber() + ") amount = \n" + amount + " - " + type);
        }
    }
}
