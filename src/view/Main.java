package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import global.Constants.ELoginDialog;

public class Main {
	//component
	private LoginDialog loginDialog;
	private MainFrame mainFrame;

	public Main() {
		//child window ������ ������
		ActionHandler actionHandler = new ActionHandler();
		this.loginDialog =  new LoginDialog(actionHandler); 
	}	
	
	public void initialize() {
		this.loginDialog.initialize();
	}	
	
	//���������Ӱ� �α��� ������ ���
	private void loginOk() throws FileNotFoundException {
		String id = loginDialog.validateUser();
		if (id != null) {
			loginDialog.dispose();
			this.mainFrame = new MainFrame();   
			this.mainFrame.initialize(id);//���������δ� setVisible ���� �ʱ�ȭ�ؾ���/setVisible : ������ �׸� �� ������ �׷����� ��
		}
	}
	
	private void loginCancel() {
		loginDialog.cancel();
		loginDialog.dispose();
	}
	
	
	class ActionHandler implements ActionListener { // implements == realize
		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (actionEvent.getActionCommand().equals(ELoginDialog.okButton.getString())) { //getSource() : �̺�Ʈ�� �߻��� ������Ʈ				
				try {
					loginOk();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}					

			} else if (actionEvent.getActionCommand().equals(ELoginDialog.cancelButton.getString())) {
				loginCancel();
			}		
		}
	}
	public void cancel() {
		mainFrame.cancel();
	}
		
	public static void main(String[] args) {
		Main main;
		main = new Main();
		main.initialize();//main�� �� ������� �Ŀ� �ʱ�ȭ
	}
}
