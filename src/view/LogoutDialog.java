package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import global.Constants.ELogoutDialog;


public class LogoutDialog extends JDialog {
	private static final long serialVersionUID = ELogoutDialog.serialVersionUID.getInt();
	
	private JLabel questionLabel;
	private JButton okButton;
	private JButton cancelButton;
	
	public LogoutDialog() {
		this.setTitle(ELogoutDialog.title.getString());
		this.setSize(ELogoutDialog.width.getInt(), ELogoutDialog.height.getInt());
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize(); 
		this.setLocation(
				dim.width/2 - this.getSize().width/2, // xÁÂÇ¥
				dim.height/2 - this.getSize().height/2); // yÁÂÇ¥
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		//components
		this.setLayout(new FlowLayout());
	  
		JPanel panel1 = new JPanel();
		questionLabel = new JLabel(ELogoutDialog.questionLabel.getString());
		panel1.add(questionLabel);
		this.add(panel1);
		
		ActionHandler2 clickHandler = new ActionHandler2();
		
		JPanel panel2 = new JPanel();
		okButton = new JButton(ELogoutDialog.okButton.getString());
		okButton.addActionListener(clickHandler); 
		okButton.setActionCommand(ELogoutDialog.okButton.getString()); 
		panel2.add(okButton);
      
		cancelButton = new JButton(ELogoutDialog.cancelButton.getString());
		cancelButton.addActionListener(clickHandler); 
		cancelButton.setActionCommand(ELogoutDialog.cancelButton.getString());
		panel2.add(cancelButton);
		this.add(panel2);
		
		this.setVisible(true); 	
	}
	
	public void initialize() {
		
	}
	
	public void cancel() {
		this.dispose();
	}
	
	class ActionHandler2 implements ActionListener { // implements == realize
		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (actionEvent.getActionCommand().equals(ELogoutDialog.okButton.getString())) { 	
				cancel();
				Main main = new Main();
				main.initialize();
				
			} else if (actionEvent.getActionCommand().equals(ELogoutDialog.cancelButton.getString())) {
				cancel();
			}
		}
	}
}
