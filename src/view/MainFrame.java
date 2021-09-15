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
		//attributes(�Ӽ�)
		this.setTitle(EMainFrame.title.getString());
		this.setSize(EMainFrame.width.getInt(), EMainFrame.height.getInt()); 
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize(); 
		this.setLocation(
				dim.width/2 - this.getSize().width/2, // x��ǥ
				dim.height/2 - this.getSize().height/2); // y��ǥ
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x������ ������->windowClosing
		
		//components(�ڽ�)
		WindowListener WindowListener = new WindowHandler();
		this.addWindowListener(WindowListener);
		LayoutManager layoutManager = new BorderLayout();
		this.setLayout(layoutManager);
		
		ActionHandler actionHandler = new ActionHandler();
		this.personalInfo = new PersonalInfoPanel(actionHandler);
		this.add(this.personalInfo, BorderLayout.NORTH);
	
		this.registration = new RegistrationPanel();
		this.add(this.registration, BorderLayout.CENTER);	
		
		this.setVisible(true);//������ ������ ����
	}

	public void initialize(String id) throws FileNotFoundException {//main���� ������ id
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
		public void windowClosing(WindowEvent arg0) {//���̳ζ����� ������ ��
			finish();
		}

		@Override
		public void windowDeactivated(WindowEvent arg0) {
		}

		@Override
		public void windowDeiconified(WindowEvent arg0) {
		}

		@Override
		public void windowIconified(WindowEvent arg0) {//minimize������ ��
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
				LogoutDialog logoutDialog = new LogoutDialog();//�α׾ƿ� ��ư ������ ���̾�α� �߰�
				cancel();//������������ ����
			} else if (actionEvent.getActionCommand().equals(EPersonalInfoPanel.btnShowInfo.getString())) {
				click();//�������� ���� ��ư
				 

			} else if (actionEvent.getActionCommand().equals(EPersonalInfoPanel.btnSave.getString())) {
				finish();//�����ư ������ ����, �ȳ� ���̾�α� ����
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
