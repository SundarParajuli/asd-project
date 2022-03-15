package creditcard;


import creditcard.commands.*;
import framework.ui.MainFrm;
import framework.ui.UIController;

import javax.swing.*;

public class Application {

    public static void main(String[] args){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            UIController frm = MainFrm.getInstance();
            frm.init("Credit Card Application", new CreditUIConfig());

            //commands
            frm.setAddPersonalAccountCommand(new AddPersonalAccountCommand());
            frm.setAddCompanyAccountCommand(new AddCompanyAccountCommand());
            frm.setDepositCommand(new DepositAccountCommand());
            frm.setWithdrawCommand(new WithdrawCommand());
            frm.setAddInterestCommand(new AddInterestCommand());
            frm.setReportCommand(new ReportCommand());

            //Create a new instance of our application's frame, and make it visible.
            frm.setVisible(true);
        } catch (Throwable t) {
            t.printStackTrace();
            System.exit(1);
        }
    }
}
