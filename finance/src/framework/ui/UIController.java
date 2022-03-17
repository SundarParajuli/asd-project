package framework.ui;


import framework.commands.Command;
import framework.entity.Customer;

public interface UIController {
    void init(String title, UIConfiguration config);
    void setAddPersonalAccountCommand(Command addAccountCommand);
    void setAddCompanyAccountCommand(Command addAccountCommand);
    void setReportCommand(Command reportCommand);
    void setAddInterestCommand(Command addInterestCommand);
    void setDepositCommand(Command depositCommand);
    void setWithdrawCommand(Command withdrawCommand);
    void setVisible(boolean value);

    String getAccountType();
    String getAccountNumber();
    Customer getCustomer();
    String getAmount();
}
