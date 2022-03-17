package framework.commands;

import framework.entity.AccountService;
import framework.ui.UIController;


public class AddCAccountCommand implements Command {
	private AccountService accountService;

	public AddCAccountCommand(AccountService accountService) {
		this.accountService = accountService;
	}

	public void execute(UIController uiController) {
		accountService.createAccount(uiController.getAccountNumber(),
							uiController.getCustomer(), uiController.getAccountType());
		}
}
