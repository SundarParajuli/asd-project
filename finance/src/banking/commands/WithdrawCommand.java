package banking.commands;


import banking.BankingAccountService;
import framework.ui.Command;
import framework.ui.UIControl;

public class WithdrawCommand implements Command {
    @Override
    public void execute(UIControl control) {
        BankingAccountService.getInstance().withdraw(control.getAccountNumber(), Double.parseDouble(control.getAmount()));
    }
}
