package framework.commands;

import framework.entity.AccountService;
import framework.ui.UIController;

public class WithdrawFromAccountCommand implements Command {
	

	private AccountService accountService;

	public WithdrawFromAccountCommand(AccountService accountService) {
		this.accountService = accountService;
	}

	
    @Override
    public void execute(UIController uiController) {
    	accountService.withdraw(uiController.getAccountNumber(),
    											Double.parseDouble(uiController.getAmount()));
        
    }
}
