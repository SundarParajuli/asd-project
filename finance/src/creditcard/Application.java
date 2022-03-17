package creditcard;


import framework.commands.*;
import framework.ui.HomeFrame;
import framework.ui.UIController;

import javax.swing.*;

public class Application {

    public static void main(String[] args){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            UIController uiController = HomeFrame.getInstance();
            uiController.init("Credit Card Application", new CreditUIConfiguration());

            //commands
            uiController.setAddPersonalAccountCommand(new AddPAccountCommand(CreditAccountService.getInstance()));
            uiController.setAddCompanyAccountCommand(new AddCAccountCommand(CreditAccountService.getInstance()));
            uiController.setDepositCommand(new DepositToAccountCommand(CreditAccountService.getInstance()));
            uiController.setWithdrawCommand(new WithdrawFromAccountCommand(CreditAccountService.getInstance()));
            uiController.setAddInterestCommand(new AddInterestToAccountCommand(CreditAccountService.getInstance()));
            uiController.setReportCommand(new GenerateReportCommand(CreditAccountService.getInstance()));

            uiController.setVisible(true);
        } catch (Throwable t) {
            t.printStackTrace();
            System.exit(1);
        }
    }
}
