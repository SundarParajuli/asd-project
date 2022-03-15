package banking.commands;


import banking.BankingAccountService;
import framework.ui.Command;
import framework.ui.UIController;

public class AddPersonalAccountCommand implements Command {
    @Override
    public void execute(UIController uiController) {
        BankingAccountService.getInstance()
                .createAccount(
                        uiController.getAccountNumber(),
                        uiController.getCustomer(),
                        uiController.getAccountType()
                );
    }
}
