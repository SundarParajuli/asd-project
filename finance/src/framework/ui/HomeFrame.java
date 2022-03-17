package framework.ui;


import banking.BankingUIConfiguration;
import creditcard.CreditUIConfiguration;
import framework.commands.Command;
import framework.commands.NoCommand;
import framework.entity.AccountObserver;
import framework.entity.Account;
import framework.entity.AccountService;
import framework.entity.Customer;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.*;

public class HomeFrame extends FrameCreationTemplate implements UIController, AccountObserver
{
	private Command addPersonalAccountCommand;
	private Command addCompanyAccountCommand;
	private Command reportCommand;
	private Command addInterestCommand;
	private Command depositCommand;
	private Command withdrawCommand;

	private Collection<String> accountTypes;
	private Customer customer;
	private String accountNumber;
	private String accountType;

	JPanel JPanel = new JPanel();

	String accountNmbr;
	String clientName;
	String street;
	String city;
	String zip;
	String state;
	String amount;
    boolean newaccount;

    private AccountService subject;
    private UIConfiguration uiConfiguration;
    private static volatile HomeFrame myframe;


	private HomeFrame()
	{
		this.addPersonalAccountCommand = NoCommand.getInstance();
		this.addCompanyAccountCommand = NoCommand.getInstance();
		this.reportCommand = NoCommand.getInstance();
		this.addInterestCommand = NoCommand.getInstance();
		this.depositCommand = NoCommand.getInstance();
		this.withdrawCommand = NoCommand.getInstance();
		this.accountTypes = new ArrayList<>();
	}

	public static HomeFrame getInstance() {
		if (myframe == null) {
			synchronized (HomeFrame.class) {
				if (myframe == null) {
					myframe = new HomeFrame();
				}
			}
		}
		return myframe;
	}

	public void init(String title, UIConfiguration uiConfiguration) {
		Map<String,ActionListener> buttons = new HashMap<>();
		if(uiConfiguration instanceof CreditUIConfiguration){

			buttons.put("Add personal account",personalAccount);
			buttons.put("Add company account",companyAccount);
			buttons.put("Charge",withdraw);
			buttons.put("Deposit",deposit);
			buttons.put("Add Interest",addInterest);
			buttons.put("Generate Report", generateReport);
			buttons.put("Exit",exit);
			this.uiConfiguration = uiConfiguration;
			this.accountTypes = this.uiConfiguration.getAccountTypes();
		}else if(uiConfiguration instanceof BankingUIConfiguration){

			buttons.put("Add personal account",personalAccount);
			buttons.put("Add company account",companyAccount);
			buttons.put("Withdraw",withdraw);
			buttons.put("Deposit",deposit);
			buttons.put("Add Interest",addInterest);
			buttons.put("Generate Report", generateReport);
			buttons.put("Exit",exit);
			this.uiConfiguration = uiConfiguration;
			this.accountTypes = this.uiConfiguration.getAccountTypes();
		}

		generateForm(title, uiConfiguration,buttons);
	}

	public String getAmount() {
		return amount;
	}

	private final ActionListener exit = (ActionListener) -> {
		System.exit(0);
	};
	private final ActionListener personalAccount = (ActionListener) -> {
		openDialog(new JDialog_AddPersonalAccount(myframe));
		if (newaccount) {
			this.addPersonalAccountCommand.execute(this);
		}
	};
	private final ActionListener companyAccount = (ActionListener) -> {
		openDialog(new JDialog_AddCompanyAccount(myframe));
		if (newaccount) {
			this.addCompanyAccountCommand.execute(this);
		}
	};
	private final ActionListener deposit = (ActionListener) -> {
		int selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if(selection < 0) {
			JOptionPane.showMessageDialog(null, "Please select account from the record");
		   }
		if (selection >= 0) {
			accountNumber = (String) model.getValueAt(selection, uiConfiguration.getIdColumnIndex());
			openDialog(new JDialog_Deposit(myframe, accountNumber),430, 15, 275, 200);
			this.depositCommand.execute(this);
		}
	};
	private final ActionListener addInterest = (ActionListener) -> {
		this.addInterestCommand.execute(this);
		JOptionPane.showMessageDialog(null, "Add interest to all accounts", "Add interest to all accounts", JOptionPane.WARNING_MESSAGE);
	};
	private final ActionListener generateReport = (ActionListener) -> {
		this.reportCommand.execute(this);
		openDialog(new JDialogGenBill(myframe),450, 20, 600, 650);
	};
	private final ActionListener withdraw = (ActionListener) -> {
		int selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if(selection < 0){
			JOptionPane.showMessageDialog(null, "Please select account from the record");
		}
		if (selection >= 0){
			accountNumber = (String) model.getValueAt(selection, uiConfiguration.getIdColumnIndex());
			openDialog(new JDialog_Withdraw(myframe, accountNumber),430, 15, 275, 200);
			this.withdrawCommand.execute(this);
		}
	};

	void exitApplication()
	{
		try {
		    	this.setVisible(false);
		    	this.dispose();
		    	System.exit(0);
		} catch (Exception e) {
		}
	}

	@Override
	public void setAddPersonalAccountCommand(Command addAccountCommand) {
		this.addPersonalAccountCommand = addAccountCommand;
	}

	@Override
	public void setAddCompanyAccountCommand(Command addAccountCommand) {
		this.addCompanyAccountCommand = addAccountCommand;
	}

	public void setReportCommand(Command reportCommand) {
		this.reportCommand = reportCommand;
	}

	public void setAddInterestCommand(Command addInterestCommand) {
		this.addInterestCommand = addInterestCommand;
	}

	public void setDepositCommand(Command depositCommand) {
		this.depositCommand = depositCommand;
	}

	public void setWithdrawCommand(Command withdrawCommand) {
		this.withdrawCommand = withdrawCommand;
	}

	@Override
	public String getAccountType() {
		return accountType;
	}

	public Collection<String> getAccountTypes() {
		return accountTypes;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	@Override
	protected void notCommon() {
		SymWindow aSymWindow = new SymWindow();
		this.addWindowListener(aSymWindow);
	}

	@Override
	protected void setBtnBounds(JButton btn, int y) {
		btn.setBounds(468,y,192,33);
	}

	@Override
	protected void panelBounds() {
		JPanel1.setBounds(0,0,700,410);
	}

	@Override
	protected void pSetSize() {
		setSize(700,410);
	}

	@Override
	protected void tableBounds() {
		JTable1.setBounds(0, 0, 420, 0);
	}

	@Override
	protected void scrollPanelBounds() {
		JScrollPane1.setBounds(12,24,444,190);
	}

	@Override
	public void update(String type) {
		if (type.equals("report")) {
			return;
		}
		if (model.getRowCount() > 0) {
			for (int i = model.getRowCount() - 1; i > -1; i--) {
				model.removeRow(i);
			}
		}
		List<Account> accounts = this.subject.getAllAccounts();
		accounts.sort((a1, a2) -> a1.getAccountNumber().compareTo(a2.getAccountNumber()));
		accounts.forEach(this::tableRow);
		System.out.println("Updating the table on the UI.");
	}

	public void setSubject(AccountService subject) {
		this.subject = subject;
	}

	public AccountService getSubject() {
		return subject;
	}

	class SymWindow extends java.awt.event.WindowAdapter
	{
		public void windowClosing(WindowEvent event)
		{
			Object object = event.getSource();
			if (object == HomeFrame.this)
				MainFrm_windowClosing(event);
		}
	}

	void MainFrm_windowClosing(WindowEvent event)
	{
		MainFrm_windowClosing_Interaction1(event);
	}

	void MainFrm_windowClosing_Interaction1(WindowEvent event) {
		try {
			this.exitApplication();
		} catch (Exception e) {
		}
	}

	private void tableRow(Account act){
		model.addRow(this.uiConfiguration.buildRow(act));
		JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
		newaccount = false;
	}

	public void openDialog(JDialog jDialog){
		openDialog(jDialog, 450, 20, 300, 450);
	}
	public void openDialog(JDialog jDialog, int x, int y, int width, int height){
		jDialog.setBounds(x, y, width, height);
		jDialog.show();
	}
}