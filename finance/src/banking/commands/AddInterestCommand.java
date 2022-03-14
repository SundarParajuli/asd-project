package banking.commands;


import banking.BankingAccountService;
import framework.ui.Command;
import framework.ui.UIControl;

public class AddInterestCommand implements Command {
    @Override
    public void execute(UIControl control) {
        BankingAccountService.getInstance().addInterest();
    }
}
