package framework.commands;

import framework.entity.AccountService;
import framework.ui.UIController;

public class AddPersonalAccountCommand implements Command {
	

	private AccountService accountService;

	public AddPersonalAccountCommand(AccountService accountService) {
		this.accountService = accountService;
	}

	
    @Override
    public void execute(UIController uiController) {
    	accountService.createAccount(uiController.getAccountNumber(),
							uiController.getCustomer(), uiController.getAccountType());
        
    }
}
