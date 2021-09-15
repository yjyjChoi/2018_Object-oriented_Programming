package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.CPersonalInfo;
import global.Constants.EPersonalInfoPanel;
import valueObject.VCPersonalInfo;

public class PersonalInfoPanel extends JPanel implements Runnable{
	private static final long serialVersionUID = EPersonalInfoPanel.serialVersionUID.getInt();
	//날짜, 시간
	private JLabel lbTime;
	private Thread thread;
	//인사, 버튼들
	private JLabel lbInsa;
	private JLabel lbInsaPostfix;
	private JButton btnMjWeb;
	private JButton btnInfo;
	private JButton btnRemoveAll;
	private JButton btnLogout;
	private JButton btnSave;
	//개인정보 업데이트 되는
	private JLabel lbStudentNum;
	private JTextField tfStudentNum;
	private JLabel lbMajor;
	private JTextField tfMajor;
	private JLabel lbLimitCredit;
	private JTextField tfCredit;


	public PersonalInfoPanel(ActionListener actionHandler) {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		//현재 날짜, 시간 패널
		JPanel timePanel = new JPanel();
		timePanel.setBackground(Color.YELLOW);
		timePanel.setLayout(new FlowLayout());
		lbTime = new JLabel();
		lbTime.setFont(new Font(EPersonalInfoPanel.fontName.getString(), Font.ROMAN_BASELINE, EPersonalInfoPanel.fontSize.getInt()));
	    if (thread == null) {
		   thread = new Thread(this);
		   thread.start();
	    }
	    timePanel.add(lbTime);
		
		//이름, 버튼 있는 패널
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.ORANGE);
		
		lbInsa = new JLabel();
		panel1.add(lbInsa);	
		lbInsaPostfix = new JLabel(EPersonalInfoPanel.lbInsaPostfix.getString());
		panel1.add(lbInsaPostfix);
		
		btnMjWeb = new JButton(EPersonalInfoPanel.btnMjWeb.getString());
		btnMjWeb.setPreferredSize(new Dimension(115,30));
		btnMjWeb.addActionListener(actionHandler);
		panel1.add(btnMjWeb);
		
		btnRemoveAll = new JButton(EPersonalInfoPanel.btnRemoveAll.getString());
		btnRemoveAll.setPreferredSize(new Dimension(115,30));
		btnRemoveAll.addActionListener(actionHandler);
		panel1.add(btnRemoveAll);
		
		ImageIcon icon1 = new ImageIcon(EPersonalInfoPanel.imageForder.getString() + EPersonalInfoPanel.catIcon2.getString());
		btnLogout = new JButton(EPersonalInfoPanel.btnLogout.getString(), icon1);
		btnLogout.setPreferredSize(new Dimension(115,30));
		btnLogout.addActionListener(actionHandler);
		panel1.add(btnLogout);
		
		ImageIcon icon2 = new ImageIcon(EPersonalInfoPanel.imageForder.getString() + EPersonalInfoPanel.catIcon1.getString());
		btnSave = new JButton(EPersonalInfoPanel.btnSave.getString(), icon2);
		btnSave.setPreferredSize(new Dimension(115,30));
		btnSave.addActionListener(actionHandler);
		panel1.add(btnSave);
		
		//개인정보 업데이트 되는 패널
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.ORANGE);
		
		btnInfo = new JButton(EPersonalInfoPanel.btnShowInfo.getString());
		btnInfo.setPreferredSize(new Dimension(115,30));
		btnInfo.addActionListener(actionHandler);
		panel2.add(btnInfo);
		
		lbStudentNum = new JLabel(EPersonalInfoPanel.lbStudentNum.getString());
		panel2.add(lbStudentNum);
		
		tfStudentNum = new JTextField(EPersonalInfoPanel.tfStudentNumSize.getInt());
		panel2.add(tfStudentNum);
		
		lbMajor = new JLabel(EPersonalInfoPanel.lbMajorPostfix.getString());
		panel2.add(lbMajor);
		
		tfMajor = new JTextField(EPersonalInfoPanel.tfMajorSize.getInt());
		panel2.add(tfMajor);
		
		lbLimitCredit = new JLabel(EPersonalInfoPanel.lbCreditPostfix.getString());
		panel2.add(lbLimitCredit);
		
		tfCredit = new JTextField(EPersonalInfoPanel.tfCreditSize.getInt());
		panel2.add(tfCredit);
		
		this.add(timePanel);
		this.add(panel1);
		this.add(panel2);
	}
	
	public void initialize(String id) {//initialize는 무조건 public
		this.showPersonalInfo(id);
	}	
	
	public void finish(String id) {
		this.clickShowPersonalInfo(id);
	}
	
	private void showPersonalInfo(String id) {//프로그램은 최대한 private로 인캡슐레이션
		CPersonalInfo cPersonalInfo = new CPersonalInfo(); 
		VCPersonalInfo vCPersonalInfo = cPersonalInfo.getPersonalInfo(id);
		this.lbInsa.setText(vCPersonalInfo.getName());	
	}
	
	private void clickShowPersonalInfo(String id) {//개인정보 보기 버튼 누르면 개인정보가 보이도록
		CPersonalInfo cPersonalInfo = new CPersonalInfo(); 
		VCPersonalInfo vCPersonalInfo = cPersonalInfo.getPersonalInfo(id);
		this.tfStudentNum.setText(vCPersonalInfo.getStudentNum());
		this.tfMajor.setText(vCPersonalInfo.getMajor());	
		this.tfCredit.setText(vCPersonalInfo.getCreditLimit());
		this.updateUI();
	}
	
	public void run() {
		while(true){
	        Calendar cal = Calendar.getInstance();
	        String clock = cal.get(Calendar.YEAR) + EPersonalInfoPanel.year.getString() +
	                    (cal.get(Calendar.MONTH)+1) + EPersonalInfoPanel.month.getString() +
	                    cal.get(Calendar.DATE) + EPersonalInfoPanel.date.getString() +
                        cal.get(Calendar.HOUR) + EPersonalInfoPanel.colon.getString() +
	                    cal.get(Calendar.MINUTE) + EPersonalInfoPanel.colon.getString() +
	                    cal.get(Calendar.SECOND);
	        lbTime.setText(clock);
	        try{
	        	Thread.sleep(1000);//1000 == 1초
	        }catch(InterruptedException e){
	        	e.printStackTrace();
	        }
		}
	}
}