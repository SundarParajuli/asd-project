package framework.ui;

import framework.entity.Company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class JDialog_AddCompanyAccount extends JDialog
{
    private HomeFrame parentFrame;
	List<JRadioButton> btnAccountTypes = new ArrayList<>();
	public JDialog_AddCompanyAccount(HomeFrame parent)
	{
		super(parent);
		parentFrame =parent;

		setTitle("Add company account");
		setModal(true);
		getContentPane().setLayout(null);
		setVisible(false);
		setSize(283,303);
		int yOffset = 0;
		SymMouse aSymMouse = new SymMouse();

		for (String actType: parentFrame.getAccountTypes()) {
			JRadioButton chk = new JRadioButton();
			chk.setText(actType);
			chk.setActionCommand(actType);
			chk.setBounds(36, yOffset,200,24);
			getContentPane().add(chk);
			chk.addMouseListener(aSymMouse);
			btnAccountTypes.add(chk);
			yOffset += 24;
		}

		nameLabel.setText("Name");
		getContentPane().add(nameLabel);
		nameLabel.setForeground(Color.black);
		nameLabel.setBounds(12,96,48,24);

		streetLabel.setText("Street");
		getContentPane().add(streetLabel);
		streetLabel.setForeground(Color.black);
		streetLabel.setBounds(12,120,48,24);

		cityLabel.setText("City");
		getContentPane().add(cityLabel);
		cityLabel.setForeground(Color.black);
		cityLabel.setBounds(12,144,48,24);

		stateLabel.setText("State");
		getContentPane().add(stateLabel);
		stateLabel.setForeground(Color.black);
		stateLabel.setBounds(12,168,48,24);

		zipLabel.setText("Zip");
		getContentPane().add(zipLabel);
		zipLabel.setForeground(Color.black);
		zipLabel.setBounds(12,192,48,24);

		noOfEmployeesLabel.setText("No of employees");
		getContentPane().add(noOfEmployeesLabel);
		noOfEmployeesLabel.setForeground(Color.black);
		noOfEmployeesLabel.setBounds(12,216,96,24);

		emailLabel.setText("Email");
		getContentPane().add(emailLabel);
		emailLabel.setForeground(Color.black);
		emailLabel.setBounds(12,240,48,24);

		getContentPane().add(JTextField_NAME);
		JTextField_NAME.setBounds(120,96,156,20);

		getContentPane().add(JTextField_CT);
		JTextField_CT.setBounds(120,144,156,20);

		getContentPane().add(JTextField_ST);
		JTextField_ST.setBounds(120,168,156,20);

		getContentPane().add(JTextField_STR);
		JTextField_STR.setBounds(120,120,156,20);

		getContentPane().add(JTextField_ZIP);
		JTextField_ZIP.setBounds(120,192,156,20);

		getContentPane().add(JTextField_NoOfEmp);
		JTextField_NoOfEmp.setBounds(120,216,156,20);

		getContentPane().add(JTextField_EM);
		JTextField_EM.setBounds(120,240,156,20);

		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		getContentPane().add(JButton_OK);
		JButton_OK.setBounds(48,276,84,24);

		JButton_Cancel.setText("Cancel");
		JButton_Cancel.setActionCommand("Cancel");
		getContentPane().add(JButton_Cancel);
		JButton_Cancel.setBounds(156,276,84,24);

		accountNumberLabel.setText("Acc Nr");
		getContentPane().add(accountNumberLabel);
		accountNumberLabel.setForeground(Color.black);
		accountNumberLabel.setBounds(12,72,48,24);

		getContentPane().add(JTextField_ACNR);
		JTextField_ACNR.setBounds(120,72,156,20);

		SymAction lSymAction = new SymAction();
		JButton_OK.addActionListener(lSymAction);
		JButton_Cancel.addActionListener(lSymAction);
	}


	JLabel nameLabel = new JLabel();
	JLabel streetLabel = new JLabel();
	JLabel cityLabel = new JLabel();
	JLabel stateLabel = new JLabel();
	JLabel zipLabel = new JLabel();
	JLabel noOfEmployeesLabel = new JLabel();
	JLabel emailLabel = new JLabel();
	JTextField JTextField_NAME = new JTextField();
	JTextField JTextField_CT = new JTextField();
	JTextField JTextField_ST = new JTextField();
	JTextField JTextField_STR = new JTextField();
	JTextField JTextField_ZIP = new JTextField();
	JTextField JTextField_NoOfEmp = new JTextField();
	JTextField JTextField_EM = new JTextField();
	JButton JButton_OK = new JButton();
	JButton JButton_Cancel = new JButton();
	JLabel accountNumberLabel = new JLabel();
	JTextField JTextField_ACNR = new JTextField();


	class SymAction implements java.awt.event.ActionListener
	{
		public void actionPerformed(java.awt.event.ActionEvent event)
		{
			Object object = event.getSource();
			if (object == JButton_OK)
				JButtonOK_actionPerformed(event);
			else if (object == JButton_Cancel)
				btnCancelActionPerformed(event);
		}
	}
	class SymMouse extends java.awt.event.MouseAdapter
	{
		public void mouseClicked(java.awt.event.MouseEvent event)
		{
			JRadioButton selectedBtn = (JRadioButton) event.getSource();
			for (JRadioButton btn: btnAccountTypes) {
				btn.setSelected(btn == selectedBtn);
			}
		}
	}

	void JButtonOK_actionPerformed(java.awt.event.ActionEvent event)
	{
       parentFrame.accountNmbr =JTextField_ACNR.getText();
       parentFrame.clientName=JTextField_NAME.getText();
       parentFrame.street=JTextField_STR.getText();
       parentFrame.city=JTextField_CT.getText();
       parentFrame.zip=JTextField_ZIP.getText();
       parentFrame.state=JTextField_ST.getText();


		Company company = new Company(
				1,
				JTextField_NAME.getText(),
				JTextField_STR.getText(),
				JTextField_CT.getText(),
				JTextField_ST.getText(),
				Integer.parseInt(JTextField_ZIP.getText()),
				JTextField_EM.getText(),
				Integer.parseInt(JTextField_NoOfEmp.getText())
		);
		parentFrame.setCustomer(company);
		btnAccountTypes.stream().filter(JRadioButton::isSelected)
				.findFirst()
				.ifPresent(jRadioButton -> parentFrame.setAccountType(jRadioButton.getText()));
		parentFrame.setAccountNumber(JTextField_ACNR.getText());
		parentFrame.newaccount = true;
		dispose();
	}

	void btnCancelActionPerformed(java.awt.event.ActionEvent event)
	{
		dispose();
			 
	}
}