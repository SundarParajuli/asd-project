package banking.commands;


import banking.BankingAccountService;
import framework.ui.Command;
import framework.ui.UIControl;

public class DepositAccountCommand implements Command {
    @Override
    public void execute(UIControl control) {
        BankingAccountService.getInstance().deposit(control.getAccountNumber(),Double.parseDouble(control.getAmount()));
    }
}
