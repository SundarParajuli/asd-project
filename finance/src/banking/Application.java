package banking;



import banking.commands.*;
import framework.ui.MainFrm;
import framework.ui.UIController;

import javax.swing.*;

public class Application {
    public static void main(String[] args){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            UIController uiController = MainFrm.getInstance();
            uiController.init("Banking Application", new BankingUIConfig());

            //commands
            uiController.setAddPersonalAccountCommand(new AddPersonalAccountCommand());
            uiController.setAddCompanyAccountCommand(new AddCompanyAccountCommand());
            uiController.setDepositCommand(new DepositAccountCommand());
            uiController.setWithdrawCommand(new WithdrawCommand());
            uiController.setAddInterestCommand(new AddInterestCommand());

            //Create a new instance of our application's frame, and make it visible.
            uiController.setVisible(true);
        } catch (Throwable t) {
            t.printStackTrace();
            System.exit(1);
        }
    }
}
