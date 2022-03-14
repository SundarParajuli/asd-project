package banking;



import banking.commands.*;
import framework.ui.MainFrm;
import framework.ui.UIControl;

import javax.swing.*;

public class Application {
    public static void main(String[] args){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            UIControl frm = MainFrm.getInstance();
            frm.init("Banking Application", new BankingUIConfig());

            //commands
            frm.setAddPersonalAccountCommand(new AddPersonalAccountCommand());
            frm.setAddCompanyAccountCommand(new AddCompanyAccountCommand());
            frm.setDepositCommand(new DepositAccountCommand());
            frm.setWithdrawCommand(new WithdrawCommand());
            frm.setAddInterestCommand(new AddInterestCommand());

            //Create a new instance of our application's frame, and make it visible.
            frm.setVisible(true);
        } catch (Throwable t) {
            t.printStackTrace();
            System.exit(1);
        }
    }
}