package framework.commands;

import framework.entity.AccountService;
import framework.ui.Command;
import framework.ui.UIController;


public class AddCompanyAccountCommand implements Command {
	private AccountService accountService;

	public AddCompanyAccountCommand(AccountService accountService) {
		this.accountService = accountService;
	}

	public void execute(UIController uiController) {
		accountService.createAccount(uiController.getAccountNumber(),
							uiController.getCustomer(), uiController.getAccountType());
		}
}
