package framework.observer;

import framework.entity.AccountService;
import framework.entity.Personal;

public class BankingSMSSender extends Sender{
    public BankingSMSSender(AccountService accountService) {
        super(accountService);
    }

    @Override
    public void update(String type) {

        if (type.equalsIgnoreCase("withdraw") || type.equalsIgnoreCase("deposit") || type.equalsIgnoreCase("charge")) {
            if (getAccount().getCustomer() instanceof Personal) {
                if (getAmount() > 500 || getAccount().getBalance() < 0) {
                    System.out.println("Sending SMS to: " + getAccount().getCustomer().getEmail()
                            + " For Transaction in account (" + getAccount().getAccountNumber() + ") amount = \n\t\t" + getAmount() + " - " + type);
                }
            }
        }
    }
}
