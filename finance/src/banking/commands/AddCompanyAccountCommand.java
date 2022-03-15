package banking.commands;


import banking.BankingAccountService;
import framework.ui.Command;
import framework.ui.UIController;

public class AddCompanyAccountCommand implements Command {

    public void execute(UIController uiController) {
        BankingAccountService.getInstance()
                .createAccount(
                        uiController.getAccountNumber(),
                        uiController.getCustomer(),
                        uiController.getAccountType()
                );
    }
}
