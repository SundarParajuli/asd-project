package framework.commands;


import framework.entity.AccountService;
import framework.ui.UIController;

public class AddInterestToAccountCommand implements Command {

	private AccountService accountService;

	public AddInterestToAccountCommand(AccountService accountService) {
		this.accountService = accountService;
	}

	@Override
	public void execute(UIController uiController) {
		accountService.addInterest();
	}
}
