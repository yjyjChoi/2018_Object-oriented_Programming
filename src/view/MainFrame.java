package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.net.URI;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import global.Constants.EMainFrame;
import global.Constants.EPersonalInfoPanel;
import global.Constants.ESaveNotice;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = EMainFrame.serialVersionUID.getInt();
	
	private PersonalInfoPanel personalInfo;
	private RegistrationPanel registration;
	private String id;
	
	//constructor
	public MainFrame() {
		//attributes(속성)
		this.setTitle(EMainFrame.title.getString());
		this.setSize(EMainFrame.width.getInt(), EMainFrame.height.getInt()); 
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize(); 
		this.setLocation(
				dim.width/2 - this.getSize().width/2, // x좌표
				dim.height/2 - this.getSize().height/2); // y좌표
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x누르면 꺼져라->windowClosing
		
		//components(자식)
		WindowListener WindowListener = new WindowHandler();
		this.addWindowListener(WindowListener);
		LayoutManager layoutManager = new BorderLayout();
		this.setLayout(layoutManager);
		
		ActionHandler actionHandler = new ActionHandler();
		this.personalInfo = new PersonalInfoPanel(actionHandler);
		this.add(this.personalInfo, BorderLayout.NORTH);
	
		this.registration = new RegistrationPanel();
		this.add(this.registration, BorderLayout.CENTER);	
		
		this.setVisible(true);//무조건 마지막 라인
	}

	public void initialize(String id) throws FileNotFoundException {//main에서 가져온 id
		this.id = id;
		this.personalInfo.initialize(id);
		this.registration.initialize(id);
	}
	
	public void finish() {
		//this.personalInfo.finish(this.id);
		this.registration.finish(this.id);
	}
	
	private void click() {
		this.personalInfo.finish(this.id);
		//this.registration.finish(this.id);
	}
	
	private void removeAllLectures() {
		this.registration.removeAllLectures();
	}
	
	private class WindowHandler implements WindowListener {
		@Override
		public void windowActivated(WindowEvent arg0) {	
		}

		@Override
		public void windowClosed(WindowEvent arg0) {
		}

		@Override
		public void windowClosing(WindowEvent arg0) {//파이널라이즈 만들어야 함
			finish();
		}

		@Override
		public void windowDeactivated(WindowEvent arg0) {
		}

		@Override
		public void windowDeiconified(WindowEvent arg0) {
		}

		@Override
		public void windowIconified(WindowEvent arg0) {//minimize눌렀을 때
		}

		@Override
		public void windowOpened(WindowEvent arg0) {
		}	
	}
	
	public void cancel() {
		this.dispose();
	}
	
	
	class ActionHandler implements ActionListener { 
		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (actionEvent.getActionCommand().equals(EPersonalInfoPanel.btnLogout.getString())) { 	
				LogoutDialog logoutDialog = new LogoutDialog();//로그아웃 버튼 누르면 다이얼로그 뜨게
				cancel();//메인프레임은 종료
			} else if (actionEvent.getActionCommand().equals(EPersonalInfoPanel.btnShowInfo.getString())) {
				click();//개인정보 보기 버튼
				 

			} else if (actionEvent.getActionCommand().equals(EPersonalInfoPanel.btnSave.getString())) {
				finish();//저장버튼 누르면 저장, 안내 다이얼로그 띄우기
				JOptionPane.showMessageDialog(personalInfo,
						ESaveNotice.message.getString(),
						ESaveNotice.messageTitle.getString(),
						JOptionPane.INFORMATION_MESSAGE);
			} else if (actionEvent.getActionCommand().equals(EPersonalInfoPanel.btnRemoveAll.getString())) {
				removeAllLectures();
			} else if (actionEvent.getActionCommand().equals(EPersonalInfoPanel.btnMjWeb.getString())) {
				try {
			        Desktop.getDesktop().browse(new URI((EPersonalInfoPanel.mjWebAddress.getString())));
			    } catch (Exception e) {
			        e.printStackTrace();
			    }
			}
		}
	}
}
