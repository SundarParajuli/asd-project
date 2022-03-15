package banking;



import framework.commands.*;
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
            frm.setAddPersonalAccountCommand(new AddPersonalAccountCommand(BankingAccountService.getInstance()));
            frm.setAddCompanyAccountCommand(new AddCompanyAccountCommand(BankingAccountService.getInstance()));
            frm.setDepositCommand(new DepositAccountCommand(BankingAccountService.getInstance()));
            frm.setWithdrawCommand(new WithdrawCommand(BankingAccountService.getInstance()));
            frm.setAddInterestCommand(new AddInterestCommand(BankingAccountService.getInstance()));

            //Create a new instance of our application's frame, and make it visible.
            frm.setVisible(true);
        } catch (Throwable t) {
            t.printStackTrace();
            System.exit(1);
        }
    }
}
