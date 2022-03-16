package framework.commands;


import framework.entity.AccountService;
import framework.ui.Command;
import framework.ui.UIController;

public class AddInterestCommand implements Command {

	private AccountService accountService;

	public AddInterestCommand(AccountService accountService) {
		this.accountService = accountService;
	}

	@Override
	public void execute(UIController control) {
		accountService.addInterest();
	}
}
