package creditcard.commands;


import creditcard.CreditAccountService;
import framework.ui.Command;
import framework.ui.UIControl;

public class DepositAccountCommand implements Command {
    @Override
    public void execute(UIControl control) {
        CreditAccountService.getInstance().deposit(control.getAccountNumber(),Double.parseDouble(control.getAmount()));
    }
}
