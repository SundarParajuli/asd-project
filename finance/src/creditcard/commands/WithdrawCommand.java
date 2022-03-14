package creditcard.commands;

import creditcard.CreditAccountService;
import framework.ui.Command;
import framework.ui.UIControl;

public class WithdrawCommand implements Command {
    @Override
    public void execute(UIControl control) {
        CreditAccountService.getInstance().withdraw(control.getAccountNumber(), Double.parseDouble(control.getAmount()));
    }
}
