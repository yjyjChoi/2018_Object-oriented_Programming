package global;

public class Constants {
	//enumeration(같은 타입의 원소들의 집합)-하나는 숫자 하나는 글자 안됨
	public static enum EDataFileName {//static : 타입 따로 안만들어도 고정적으로 메모리를 초기에 할당해서 알아서 베리어블 미리 만들어놔라(new안해도 됨)
		path("data/"),
		root("root"),
		login("login"),
		personalInfo("student");
		//()안하면 값을 가지지않고 순서만
		
		private String value;
		private EDataFileName(String value) {this.value = value;}
		public String getString() {return this.value;}
	}
	
	public static enum EMainFrame {
		serialVersionUID("1"),
		title("수강신청"),
		width("800"),
		height("600");
		
		
		private String value;
		private EMainFrame(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	
	public static enum ESaveNotice {
		messageTitle("알림"),
		message("내용이 임시저장 됩니다");
		
		private String value;
		private ESaveNotice(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	
	public static enum ELoginDialog {
		serialVersionUID("1"),
		title("로그인"),
		width("300"),
		height("200"),
		nameLabel(" 아이디   "),
		nameTextSize("15"),
		passwordLabel("비밀번호"),
		passwordTextSize("15"),
		//button&image
		okButton("확인"),
		cancelButton("취소"),
		imageForder("image/"),
		catIcon1("cat1.png"),
		catIcon2("cat2.png");
		
		private String value;
		private ELoginDialog(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	
	public static enum EPersonalInfoPanel {//superclass 상속 받을 것
		serialVersionUID("1"),
		//data&time
		fontName("Font"),
		fontSize("15"),
		year("년 "),
		month("월 "),
		date("일   "),
		colon(":"),
		//insa&button
		lbInsaPostfix("님 안녕하세요"),
		btnShowInfo("개인정보 보기"),
		btnMjWeb("홈페이지"),
		mjWebAddress("http://www.mju.ac.kr/mbs/mjukr/index.jsp?SWIFT_SESSION_CHK=false"),
		btnRemoveAll("전체삭제"),
		btnLogout("로그아웃"),
		btnSave("임시저장"),
		imageForder("image/"),
		catIcon1("cat1.png"),
		catIcon2("cat2.png"),
		//info
		lbStudentNum("    학번"),
		tfStudentNumSize("6"),
		lbMajorPostfix("    학과"),
		tfMajorSize("9"),
		lbCreditPostfix("    신청 가능 학점"),
		tfCreditSize("2");
	
		private String value;
		private EPersonalInfoPanel(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	
	public static enum EErrorDialog {
		serialVersionUID("1"),
		title("오류"),
		message("잘못 입력했음");
		
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
		id("강좌번호"),
		name("강좌명"),
		professorName("담당교수"),
		credit("학점"),
		time("시간");
		
		private String value;
		private ELecturePanel(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	
	public static enum EBasketPanel {
		serialVersionUID("1"),
		name("강좌명");
		
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
		name("강좌명");
		
		private String value;
		private EInfoPanel(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	
	public static enum ELogoutDialog {
		serialVersionUID("1"),
		title("로그아웃"),
		width("300"),
		height("160"),
		questionLabel("다시 로그인 하시겠습니까?"),
		okButton("예"),
		cancelButton("아니오");
		
		private String value;
		private ELogoutDialog(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
}
