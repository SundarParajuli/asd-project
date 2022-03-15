package banking.commands;


import banking.BankingAccountService;
import framework.ui.Command;
import framework.ui.UIController;

public class AddInterestCommand implements Command {
    @Override
    public void execute(UIController uiController) {
        BankingAccountService.getInstance().addInterest();
    }
}
