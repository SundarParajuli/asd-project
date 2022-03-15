package creditcard.commands;

import creditcard.CreditAccountService;
import framework.ui.Command;
import framework.ui.UIController;

public class WithdrawCommand implements Command {
    @Override
    public void execute(UIController control) {
        CreditAccountService.getInstance().withdraw(control.getAccountNumber(), Double.parseDouble(control.getAmount()));
    }
}
