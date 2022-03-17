package framework.commands;

import framework.entity.AccountService;
import framework.ui.UIController;

public class DepositToAccountCommand implements Command {
	

	private AccountService accountService;

	public DepositToAccountCommand(AccountService accountService) {
		this.accountService = accountService;
	}

	
    @Override
    public void execute(UIController uiController) {
    	accountService.deposit(uiController.getAccountNumber(),
							Double.parseDouble(uiController.getAmount()));
        
    }
}
