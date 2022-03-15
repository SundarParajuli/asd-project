package creditcard;


import framework.commands.*;
import framework.ui.MainFrm;
import framework.ui.UIController;

import javax.swing.*;

public class Application {

    public static void main(String[] args){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            UIController uiController = MainFrm.getInstance();
            uiController.init("Credit Card Application", new CreditUIConfiguration());

            //commands
            uiController.setAddPersonalAccountCommand(new AddPersonalAccountCommand(CreditAccountService.getInstance()));
            uiController.setAddCompanyAccountCommand(new AddCompanyAccountCommand(CreditAccountService.getInstance()));
            uiController.setDepositCommand(new DepositAccountCommand(CreditAccountService.getInstance()));
            uiController.setWithdrawCommand(new WithdrawCommand(CreditAccountService.getInstance()));
            uiController.setAddInterestCommand(new AddInterestCommand(CreditAccountService.getInstance()));
            uiController.setReportCommand(new ReportCommand(CreditAccountService.getInstance()));

            //Create a new instance of our application's frame, and make it visible.
            uiController.setVisible(true);
        } catch (Throwable t) {
            t.printStackTrace();
            System.exit(1);
        }
    }
}
