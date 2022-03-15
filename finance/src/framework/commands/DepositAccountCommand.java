package framework.commands;

import framework.entity.AccountService;
import framework.ui.Command;
import framework.ui.UIController;

public class DepositAccountCommand implements Command {
	

	private AccountService accountService;

	public DepositAccountCommand(AccountService accountService) {
		this.accountService = accountService;
	}

	
    @Override
    public void execute(UIController control) {
    	accountService.deposit(control.getAccountNumber(),
							Double.parseDouble(control.getAmount()));
        
    }
}
