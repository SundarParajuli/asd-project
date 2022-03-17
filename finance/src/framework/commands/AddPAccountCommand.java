package framework.commands;

import framework.entity.AccountService;
import framework.ui.UIController;

public class AddPAccountCommand implements Command {
	

	private AccountService accountService;

	public AddPAccountCommand(AccountService accountService) {
		this.accountService = accountService;
	}

	
    @Override
    public void execute(UIController uiController) {
    	accountService.createAccount(uiController.getAccountNumber(),
							uiController.getCustomer(), uiController.getAccountType());
        
    }
}
