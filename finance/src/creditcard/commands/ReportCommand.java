package creditcard.commands;


import creditcard.CreditAccountService;
import framework.ui.Command;
import framework.ui.UIController;

public class ReportCommand implements Command {
    @Override
    public void execute(UIController control) {
        CreditAccountService.getInstance().buildReport();
    }
}
