package creditcard;


import framework.commands.*;
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
            frm.setAddPersonalAccountCommand(new AddPersonalAccountCommand(CreditAccountService.getInstance()));
            frm.setAddCompanyAccountCommand(new AddCompanyAccountCommand(CreditAccountService.getInstance()));
            frm.setDepositCommand(new DepositAccountCommand(CreditAccountService.getInstance()));
            frm.setWithdrawCommand(new WithdrawCommand(CreditAccountService.getInstance()));
            frm.setAddInterestCommand(new AddInterestCommand(CreditAccountService.getInstance()));
            frm.setReportCommand(new ReportCommand(CreditAccountService.getInstance()));

            //Create a new instance of our application's frame, and make it visible.
            frm.setVisible(true);
        } catch (Throwable t) {
            t.printStackTrace();
            System.exit(1);
        }
    }
}
