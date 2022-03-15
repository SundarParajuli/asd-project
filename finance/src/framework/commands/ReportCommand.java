package framework.commands;

import framework.entity.AccountService;
import framework.ui.Command;
import framework.ui.UIController;

public class ReportCommand implements Command {
	

	private AccountService accountService;

	public ReportCommand(AccountService accountService) {
		this.accountService = accountService;
	}

	
    @Override
    public void execute(UIController control) {
    	accountService.buildReport();
        
    }
}
