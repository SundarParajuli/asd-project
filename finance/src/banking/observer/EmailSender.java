package banking.observer;


import framework.*;

public class EmailSender implements AccountObserver {
    private AccountService accountService;

    public EmailSender(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void update() {
        if (accountService.getOperation() == AccountOperation.WITHDREW || accountService.getOperation() == AccountOperation.DEPOSITED) {
            Account account = accountService.getChangedAccount();
            double amount = accountService.getChangedAmount();
            if (account.getCustomer() instanceof Personal && (amount <= 500 && account.getBalance() > 0)) {
                return;
            }
            System.out.println("Sending email to: " + account.getCustomer().getEmail() + " Operation in account (" + account.getAccountNumber() + ") amount = \n" + amount + " - " + accountService.getOperation());
        }
    }
}
