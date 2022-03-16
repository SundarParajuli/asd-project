package framework.ui;

import javax.swing.*;

public class JDialogGenBill extends JDialog
{
    
	public JDialogGenBill(MainFrm parent)
	{
		super(parent);

		getContentPane().setLayout(null);
		setSize(600,600);
		setVisible(false);
		getContentPane().add(JScrollPane1);
		JScrollPane1.setBounds(24,24,500,500);
		JScrollPane1.getViewport().add(JTextField1);
		JTextField1.setBounds(0,0,600,500);
		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		getContentPane().add(JButton_OK);
		JButton_OK.setBounds(156,550,96,24);
		JTextField1.setText(parent.getSubject().getReport());
		SymAction lSymAction = new SymAction();
		JButton_OK.addActionListener(lSymAction);
	}


	JScrollPane JScrollPane1 = new JScrollPane();
	JTextArea JTextField1 = new JTextArea();
	JButton JButton_OK = new JButton();


	class SymAction implements java.awt.event.ActionListener
	{
		public void actionPerformed(java.awt.event.ActionEvent event)
		{
			Object object = event.getSource();
			if (object == JButton_OK)
				JButtonOK_actionPerformed(event);
		}
	}

	void JButtonOK_actionPerformed(java.awt.event.ActionEvent event)
	{
		dispose();
			 
	}
}
