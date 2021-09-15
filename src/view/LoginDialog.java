package view;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.CLogin;
import global.Constants.EErrorDialog;
import global.Constants.ELoginDialog;
import global.Constants.EPersonalInfoPanel;


public class LoginDialog extends JDialog {
	private static final long serialVersionUID = ELoginDialog.serialVersionUID.getInt();
   
	private JLabel nameLabel;
	private JTextField nameText;
	private JLabel passwordLabel;
	private JTextField passwordText;
	private JButton okButton;
	private JButton cancelButton;
	private CLogin cLogin;
	
	public LoginDialog(ActionListener actionHandler) {
		//attributes
		this.setTitle(ELoginDialog.title.getString());
		this.setSize(ELoginDialog.width.getInt(), ELoginDialog.height.getInt());
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize(); 
		this.setLocation(
				dim.width/2 - this.getSize().width/2, // x좌표
				dim.height/2 - this.getSize().height/2); // y좌표
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		//components
		this.setLayout(new FlowLayout());
	  
		JPanel panel1 = new JPanel();
		nameLabel = new JLabel(ELoginDialog.nameLabel.getString());
		panel1.add(nameLabel);
		nameText = new JTextField(ELoginDialog.nameTextSize.getInt());
		panel1.add(nameText);
		this.add(panel1);
      
		JPanel panel2 = new JPanel();
		passwordLabel = new JLabel(ELoginDialog.passwordLabel.getString());
		panel2.add(passwordLabel);
		passwordText = new JTextField(ELoginDialog.passwordTextSize.getInt());
		panel2.add(passwordText);
		this.add(panel2);

		JPanel panel3 = new JPanel();
		ImageIcon icon1 = new ImageIcon(ELoginDialog.imageForder.getString() + ELoginDialog.catIcon1.getString());
		okButton = new JButton(ELoginDialog.okButton.getString(), icon1);
		okButton.setPreferredSize(new Dimension(90,30));
		okButton.addActionListener(actionHandler); 
		okButton.setActionCommand(ELoginDialog.okButton.getString()); 
		panel3.add(okButton);
      
		ImageIcon icon2 = new ImageIcon(ELoginDialog.imageForder.getString() + ELoginDialog.catIcon2.getString());
		cancelButton = new JButton(ELoginDialog.cancelButton.getString(), icon2);
		cancelButton.setPreferredSize(new Dimension(90,30));
		cancelButton.addActionListener(actionHandler); 
		cancelButton.setActionCommand(ELoginDialog.cancelButton.getString());
		panel3.add(cancelButton);
		this.add(panel3);
		
		this.setVisible(true); 	
	}
	
	public void initialize() {
		// TODO Auto-generated method stub
	}
	
	public String validateUser() {
		String id = nameText.getText();
		String password = passwordText.getText();
		
		this.cLogin = new CLogin();
		boolean result = cLogin.validateUser(id, password); 
		if (result) {
			return id;
		} else {	
			JOptionPane.showMessageDialog(this,
					EErrorDialog.message.getString(),
					EErrorDialog.title.getString(),
					JOptionPane.INFORMATION_MESSAGE);//showMessageDialog : 독립된 다이얼로그
			return null;
		}
	}
	
	public void cancel() {	
	}
}



