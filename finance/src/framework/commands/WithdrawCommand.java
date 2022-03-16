package framework.commands;

import framework.entity.AccountService;
import framework.ui.Command;
import framework.ui.UIController;

public class WithdrawCommand implements Command {
	

	private AccountService accountService;

	public WithdrawCommand(AccountService accountService) {
		this.accountService = accountService;
	}

	
    @Override
    public void execute(UIController uiController) {
    	accountService.withdraw(uiController.getAccountNumber(),
    											Double.parseDouble(uiController.getAmount()));
        
    }
}
