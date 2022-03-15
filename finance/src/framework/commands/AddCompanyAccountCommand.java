package framework.commands;

import framework.entity.AccountService;
import framework.ui.Command;
import framework.ui.UIControl;


public class AddCompanyAccountCommand implements Command {
	private AccountService accountService;

	public AddCompanyAccountCommand(AccountService accountService) {
		this.accountService = accountService;
	}

	public void execute(UIControl control) {
		accountService.createAccount(control.getAccountNumber(), 
							control.getCustomer(), control.getAccountType());
		}
}
