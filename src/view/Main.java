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
		//child window 독립적 윈도우
		ActionHandler actionHandler = new ActionHandler();
		this.loginDialog =  new LoginDialog(actionHandler); 
	}	
	
	public void initialize() {
		this.loginDialog.initialize();
	}	
	
	//메인프레임과 로그인 사이의 통신
	private void loginOk() throws FileNotFoundException {
		String id = loginDialog.validateUser();
		if (id != null) {
			loginDialog.dispose();
			this.mainFrame = new MainFrame();   
			this.mainFrame.initialize(id);//개념적으로는 setVisible 전에 초기화해야함/setVisible : 앞으로 그릴 게 있으면 그려라라는 뜻
		}
	}
	
	private void loginCancel() {
		loginDialog.cancel();
		loginDialog.dispose();
	}
	
	
	class ActionHandler implements ActionListener { // implements == realize
		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (actionEvent.getActionCommand().equals(ELoginDialog.okButton.getString())) { //getSource() : 이벤트가 발생한 오브젝트				
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
		main.initialize();//main이 다 만들어진 후에 초기화
	}
}
