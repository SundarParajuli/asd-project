package banking.commands;


import banking.BankingAccountService;
import framework.ui.Command;
import framework.ui.UIController;

public class DepositAccountCommand implements Command {
    @Override
    public void execute(UIController uiController) {
        BankingAccountService.getInstance()
                .deposit(
                        uiController.getAccountNumber(),
                        Double.parseDouble(uiController.getAmount())
                );
    }
}
