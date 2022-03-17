package framework.commands;

import framework.entity.AccountService;
import framework.ui.UIController;

public class GenerateReportCommand implements Command {



	private AccountService accountService;

	public GenerateReportCommand(AccountService accountService) {
		this.accountService = accountService;
	}

	
    @Override
    public void execute(UIController uiController) {
    	accountService.buildReport();
    }
}
