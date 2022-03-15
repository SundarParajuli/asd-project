package creditcard.commands;


import creditcard.CreditAccountService;
import framework.ui.Command;
import framework.ui.UIController;

public class AddPersonalAccountCommand implements Command {
    @Override
    public void execute(UIController control) {
        CreditAccountService.getInstance().createAccount(control.getAccountNumber(), control.getCustomer(), control.getAccountType());
    }
}
