package framework.observer;

import framework.entity.Account;
import framework.entity.AccountService;
import framework.entity.Personal;

public class BankingEmailSender extends Sender{
    public BankingEmailSender(AccountService accountService) {
        super(accountService);
    }

    @Override
    public void update(String type) {
        if (type.equalsIgnoreCase("withdraw") || type.equalsIgnoreCase("deposit") || type.equalsIgnoreCase("charge")) {
            if (getAccount().getCustomer() instanceof Personal) {
                if (getAmount() > 500 || getAccount().getBalance() < 0) {
                    System.out.println("Sending Email to: " + getAccount().getCustomer().getEmail()
                            + " For Transaction in account (" + getAccount().getAccountNumber() + ") amount = \n\t\t" + getAmount() + " - " + type);
                }
            }
        }
    }

}
