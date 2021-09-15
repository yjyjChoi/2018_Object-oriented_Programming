package global;

public class Constants {
	//enumeration(���� Ÿ���� ���ҵ��� ����)-�ϳ��� ���� �ϳ��� ���� �ȵ�
	public static enum EDataFileName {//static : Ÿ�� ���� �ȸ��� ���������� �޸𸮸� �ʱ⿡ �Ҵ��ؼ� �˾Ƽ� ������� �̸� ��������(new���ص� ��)
		path("data/"),
		root("root"),
		login("login"),
		personalInfo("student");
		//()���ϸ� ���� �������ʰ� ������
		
		private String value;
		private EDataFileName(String value) {this.value = value;}
		public String getString() {return this.value;}
	}
	
	public static enum EMainFrame {
		serialVersionUID("1"),
		title("������û"),
		width("800"),
		height("600");
		
		
		private String value;
		private EMainFrame(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	
	public static enum ESaveNotice {
		messageTitle("�˸�"),
		message("������ �ӽ����� �˴ϴ�");
		
		private String value;
		private ESaveNotice(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	
	public static enum ELoginDialog {
		serialVersionUID("1"),
		title("�α���"),
		width("300"),
		height("200"),
		nameLabel(" ���̵�   "),
		nameTextSize("15"),
		passwordLabel("��й�ȣ"),
		passwordTextSize("15"),
		//button&image
		okButton("Ȯ��"),
		cancelButton("���"),
		imageForder("image/"),
		catIcon1("cat1.png"),
		catIcon2("cat2.png");
		
		private String value;
		private ELoginDialog(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	
	public static enum EPersonalInfoPanel {//superclass ��� ���� ��
		serialVersionUID("1"),
		//data&time
		fontName("Font"),
		fontSize("15"),
		year("�� "),
		month("�� "),
		date("��   "),
		colon(":"),
		//insa&button
		lbInsaPostfix("�� �ȳ��ϼ���"),
		btnShowInfo("�������� ����"),
		btnMjWeb("Ȩ������"),
		mjWebAddress("http://www.mju.ac.kr/mbs/mjukr/index.jsp?SWIFT_SESSION_CHK=false"),
		btnRemoveAll("��ü����"),
		btnLogout("�α׾ƿ�"),
		btnSave("�ӽ�����"),
		imageForder("image/"),
		catIcon1("cat1.png"),
		catIcon2("cat2.png"),
		//info
		lbStudentNum("    �й�"),
		tfStudentNumSize("6"),
		lbMajorPostfix("    �а�"),
		tfMajorSize("9"),
		lbCreditPostfix("    ��û ���� ����"),
		tfCreditSize("2");
	
		private String value;
		private EPersonalInfoPanel(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	
	public static enum EErrorDialog {
		serialVersionUID("1"),
		title("����"),
		message("�߸� �Է�����");
		
		private String value;
		private EErrorDialog(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	
	public static enum ERegistrationPanel {
		serialVersionUID("1"),
		basketFileName("Basket"),
		resultFileName("Result");
		
		private String value;
		private ERegistrationPanel(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	
	public static enum ESelectionPanel {
		serialVersionUID("1");
		
		private String value;
		private ESelectionPanel(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	
	public static enum EDirectoryPanel {
		serialVersionUID("1");
		
		private String value;
		private EDirectoryPanel(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	
	public static enum ELecturePanel {
		serialVersionUID("1"),
		id("���¹�ȣ"),
		name("���¸�"),
		professorName("��米��"),
		credit("����"),
		time("�ð�");
		
		private String value;
		private ELecturePanel(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	
	public static enum EBasketPanel {
		serialVersionUID("1"),
		name("���¸�");
		
		private String value;
		private EBasketPanel(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	
	public static enum EMovePanel {
		serialVersionUID("1"),
		left(" < "),
		right(" > "),
		skipLeft("<<"),
		skipRight(">>"),
		leftBtn("leftButton"),
		rightBtn("rightButton"),
		skipLeftBtn("skipLeftButton"),
		skipRightBtn("skipRightButton");
		
		private String value;
		private EMovePanel(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	
	public static enum EInfoPanel {
		serialVersionUID("1"),
		name("���¸�");
		
		private String value;
		private EInfoPanel(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	
	public static enum ELogoutDialog {
		serialVersionUID("1"),
		title("�α׾ƿ�"),
		width("300"),
		height("160"),
		questionLabel("�ٽ� �α��� �Ͻðڽ��ϱ�?"),
		okButton("��"),
		cancelButton("�ƴϿ�");
		
		private String value;
		private ELogoutDialog(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
}
