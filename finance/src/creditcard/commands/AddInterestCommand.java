package creditcard.commands;


import creditcard.CreditAccountService;
import framework.ui.Command;
import framework.ui.UIControl;

public class AddInterestCommand implements Command {
    @Override
    public void execute(UIControl control) {
        CreditAccountService.getInstance().addInterest();
    }
}
