package banking.commands;


import banking.BankingAccountService;
import framework.ui.Command;
import framework.ui.UIController;

public class WithdrawCommand implements Command {
    @Override
    public void execute(UIController uiController) {
        BankingAccountService.getInstance()
                .withdraw(
                        uiController.getAccountNumber(),
                        Double.parseDouble(uiController.getAmount())
                );
    }
}
