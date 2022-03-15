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
    public void execute(UIController control) {
    	accountService.withdraw(control.getAccountNumber(), 
    											Double.parseDouble(control.getAmount()));
        
    }
}
