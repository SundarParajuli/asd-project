package framework.ui;

import framework.entity.Personal;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JDialog_AddPersonalAccount extends JDialog
{
    private HomeFrame parentFrame;
	List<JRadioButton> btnAccountTypes = new ArrayList<>();
	JLabel JLabel1 = new JLabel();
	JLabel JLabel2 = new JLabel();
	JLabel JLabel3 = new JLabel();
	JLabel JLabel4 = new JLabel();
	JLabel JLabel5 = new JLabel();
	JLabel JLabel6 = new JLabel();
	JLabel JLabel7 = new JLabel();
	JTextField JTextField_NAME = new JTextField();
	JTextField JTextField_CT = new JTextField();
	JTextField JTextField_ST = new JTextField();
	JTextField JTextField_STR = new JTextField();
	JTextField JTextField_ZIP = new JTextField();
	JTextField JTextField_BD = new JTextField();
	JTextField JTextField_EM = new JTextField();
	JButton JButton_OK = new JButton();
	JButton JButton_Cancel = new JButton();
	JTextField JTextField_ACNR = new JTextField();
	JLabel JLabel8 = new JLabel();
    
	public JDialog_AddPersonalAccount(HomeFrame parent) {
		super(parent);
		parentFrame =parent;
		setTitle("Add personal account");
		setModal(true);
		getContentPane().setLayout(null);
		setVisible(false);
		setSize(283,303);
		int yOffset = 0;
		SymMouse aSymMouse = new SymMouse();
		for (String actType: parentFrame.getAccountTypes()) {
			// Build account types radio buttons
			JRadioButton radioButton = new JRadioButton();
			radioButton.setText(actType);
			radioButton.setActionCommand(actType);
			radioButton.setBounds(36, yOffset,200,24);
			getContentPane().add(radioButton);
			radioButton.addMouseListener(aSymMouse);
			btnAccountTypes.add(radioButton);
			yOffset += 24;
		}
		JLabel1.setText("Name");
		getContentPane().add(JLabel1);
		JLabel1.setForeground(Color.black);
		JLabel1.setBounds(12,yOffset + 84,48,24);

		JLabel2.setText("Street");
		getContentPane().add(JLabel2);
		JLabel2.setForeground(Color.black);
		JLabel2.setBounds(12,yOffset + 108,48,24);

		JLabel3.setText("City");
		getContentPane().add(JLabel3);
		JLabel3.setForeground(Color.black);
		JLabel3.setBounds(12,yOffset + 132,48,24);

		JLabel4.setText("State");
		getContentPane().add(JLabel4);
		JLabel4.setForeground(Color.black);
		JLabel4.setBounds(12,yOffset + 156,48,24);

		JLabel5.setText("Zip");
		getContentPane().add(JLabel5);
		JLabel5.setForeground(Color.black);
		JLabel5.setBounds(12,yOffset + 180,48,24);

		JLabel6.setText("Birthdate");
		getContentPane().add(JLabel6);
		JLabel6.setForeground(Color.black);
		JLabel6.setBounds(12,yOffset + 204,96,24);

		JLabel7.setText("Email");
		getContentPane().add(JLabel7);
		JLabel7.setForeground(Color.black);
		JLabel7.setBounds(12,yOffset + 228,48,24);

		getContentPane().add(JTextField_NAME);
		JTextField_NAME.setBounds(84,yOffset + 84,156,20);
		getContentPane().add(JTextField_CT);
		JTextField_CT.setBounds(84,yOffset + 132,156,20);
		getContentPane().add(JTextField_ST);
		JTextField_ST.setBounds(84,yOffset + 156,156,20);
		getContentPane().add(JTextField_STR);
		JTextField_STR.setBounds(84,yOffset + 108,156,20);
		getContentPane().add(JTextField_ZIP);
		JTextField_ZIP.setBounds(84,yOffset + 180,156,20);
		getContentPane().add(JTextField_BD);
		JTextField_BD.setBounds(84,yOffset + 204,156,20);
		getContentPane().add(JTextField_EM);
		JTextField_EM.setBounds(84,yOffset + 228,156,20);
		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		getContentPane().add(JButton_OK);
		JButton_OK.setBounds(48,yOffset + 264,84,24);
		JButton_Cancel.setText("Cancel");
		JButton_Cancel.setActionCommand("Cancel");
		getContentPane().add(JButton_Cancel);
		JButton_Cancel.setBounds(156,yOffset + 264,84,24);
		getContentPane().add(JTextField_ACNR);
		JTextField_ACNR.setBounds(84,yOffset + 60,156,20);
		JLabel8.setText("Acc Nr");
		getContentPane().add(JLabel8);
		JLabel8.setForeground(Color.black);
		JLabel8.setBounds(12,yOffset + 60,48,24);

		SymAction lSymAction = new SymAction();
		JButton_OK.addActionListener(lSymAction);
		JButton_Cancel.addActionListener(lSymAction);
	}

	class SymMouse extends java.awt.event.MouseAdapter {
		public void mouseClicked(java.awt.event.MouseEvent event) {
			JRadioButton selectedBtn = (JRadioButton) event.getSource();
			for (JRadioButton btn: btnAccountTypes) {
				btn.setSelected(btn == selectedBtn);
			}
		}
	}


	class SymAction implements java.awt.event.ActionListener {
		public void actionPerformed(java.awt.event.ActionEvent event) {
			Object object = event.getSource();
			if (object == JButton_OK)
				JButtonOK_actionPerformed(event);
			else if (object == JButton_Cancel)
				btnCancelActionPerformed(event);
		}
	}

	void JButtonOK_actionPerformed(java.awt.event.ActionEvent event) {
		Personal person = new Personal(
				1,
				JTextField_NAME.getText(),
				JTextField_STR.getText(),
				JTextField_CT.getText(),
				JTextField_ST.getText(),
				Integer.parseInt(JTextField_ZIP.getText()),
				JTextField_EM.getText(),
				LocalDate.parse(JTextField_BD.getText())
		);
		parentFrame.setCustomer(person);
		btnAccountTypes.stream().filter(JRadioButton::isSelected)
				.findFirst()
				.ifPresent(jRadioButton -> parentFrame.setAccountType(jRadioButton.getText()));
		parentFrame.setAccountNumber(JTextField_ACNR.getText());
		parentFrame.newaccount = true;
       	dispose();
	}

	void btnCancelActionPerformed(java.awt.event.ActionEvent event) {
        dispose();
	}
}