package banking;

import framework.commands.*;
import framework.ui.HomeFrame;
import framework.ui.UIController;

import javax.swing.*;

public class Application {
    public static void main(String[] args){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            UIController uiController = HomeFrame.getInstance();
            uiController.init("Banking Application", new BankingUIConfiguration());


            uiController.setAddPersonalAccountCommand(new AddPAccountCommand(BankingAccountService.getInstance()));
            uiController.setAddCompanyAccountCommand(new AddCAccountCommand(BankingAccountService.getInstance()));
            uiController.setDepositCommand(new DepositToAccountCommand(BankingAccountService.getInstance()));
            uiController.setWithdrawCommand(new WithdrawFromAccountCommand(BankingAccountService.getInstance()));
            uiController.setAddInterestCommand(new AddInterestToAccountCommand(BankingAccountService.getInstance()));
            uiController.setReportCommand(new GenerateReportCommand(BankingAccountService.getInstance()));


            uiController.setVisible(true);
        } catch (Throwable t) {
            t.printStackTrace();
            System.exit(1);
        }
    }
}
