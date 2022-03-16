package banking;

import framework.commands.*;
import framework.ui.MainFrm;
import framework.ui.UIController;

import javax.swing.*;

public class Application {
    public static void main(String[] args){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            UIController uiController = MainFrm.getInstance();
            uiController.init("Banking Application", new BankingUIConfiguration());

            //commands
            uiController.setAddPersonalAccountCommand(new AddPersonalAccountCommand(BankingAccountService.getInstance()));
            uiController.setAddCompanyAccountCommand(new AddCompanyAccountCommand(BankingAccountService.getInstance()));
            uiController.setDepositCommand(new DepositAccountCommand(BankingAccountService.getInstance()));
            uiController.setWithdrawCommand(new WithdrawCommand(BankingAccountService.getInstance()));
            uiController.setAddInterestCommand(new AddInterestCommand(BankingAccountService.getInstance()));
            uiController.setReportCommand(new ReportCommand(BankingAccountService.getInstance()));

            //Create a new instance of our application's frame, and make it visible.
            uiController.setVisible(true);
        } catch (Throwable t) {
            t.printStackTrace();
            System.exit(1);
        }
    }
}
