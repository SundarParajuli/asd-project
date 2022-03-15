package framework.commands;

import framework.entity.AccountService;
import framework.ui.Command;
import framework.ui.UIControl;

public class ReportCommand implements Command {
	

	private AccountService accountService;

	public ReportCommand(AccountService accountService) {
		this.accountService = accountService;
	}

	
    @Override
    public void execute(UIControl control) {
    	accountService.buildReport();
        
    }
}
