package creditcard.commands;


import creditcard.CreditAccountService;
import framework.ui.Command;
import framework.ui.UIController;

public class DepositAccountCommand implements Command {
    @Override
    public void execute(UIController control) {
        CreditAccountService.getInstance().deposit(control.getAccountNumber(),Double.parseDouble(control.getAmount()));
    }
}
