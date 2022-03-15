package framework.commands;

import framework.entity.AccountService;
import framework.ui.Command;
import framework.ui.UIControl;

public class DepositAccountCommand implements Command {
	

	private AccountService accountService;

	public DepositAccountCommand(AccountService accountService) {
		this.accountService = accountService;
	}

	
    @Override
    public void execute(UIControl control) {
    	accountService.deposit(control.getAccountNumber(),
							Double.parseDouble(control.getAmount()));
        
    }
}
