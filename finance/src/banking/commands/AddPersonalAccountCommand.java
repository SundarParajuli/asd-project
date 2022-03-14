package banking.commands;


import banking.BankingAccountService;
import framework.ui.Command;
import framework.ui.UIControl;

public class AddPersonalAccountCommand implements Command {
    @Override
    public void execute(UIControl control) {
        BankingAccountService accountService = BankingAccountService.getInstance();
        accountService.createAccount(control.getAccountNumber(), control.getCustomer(), control.getAccountType());
    }
}
