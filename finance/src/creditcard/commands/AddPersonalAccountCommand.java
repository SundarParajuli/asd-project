package creditcard.commands;


import creditcard.CreditAccountService;
import framework.ui.Command;
import framework.ui.UIControl;

public class AddPersonalAccountCommand implements Command {
    @Override
    public void execute(UIControl control) {
        CreditAccountService.getInstance().createAccount(control.getAccountNumber(), control.getCustomer(), control.getAccountType());
    }
}
