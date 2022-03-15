package framework.commands;

import framework.entity.AccountService;
import framework.ui.Command;
import framework.ui.UIController;

public class AddPersonalAccountCommand implements Command {
	

	private AccountService accountService;

	public AddPersonalAccountCommand(AccountService accountService) {
		this.accountService = accountService;
	}

	
    @Override
    public void execute(UIController control) {
    	accountService.createAccount(control.getAccountNumber(), 
							control.getCustomer(), control.getAccountType());
        
    }
}
