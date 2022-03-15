package framework.observer;


import framework.entity.*;

public class EmailSender implements AccountObserver {
    private AccountService accountService;

    public EmailSender(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void update(String type) {
        if (type.equals("withdraw") || type.equals("deposit")) {
            Account account = accountService.getChangedAccount();
            double amount = accountService.getChangedAmount();
            if (account.getCustomer() instanceof Personal && (amount <= 500 && account.getBalance() > 0)) {
                return;
            }
            System.out.println("Sending email to: " + account.getCustomer().getEmail() + " Transaction in account (" + account.getAccountNumber() + ") amount = \n" + amount + " - " + type);
        }
    }
}
