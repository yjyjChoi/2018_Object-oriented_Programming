package valueObject;

public class VCPersonalInfo {
	private String Name;
	private String ID;
	private String Major;
	private String CreditLimit;
	private String StudentNum;
	
	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}
	
	public String getMajor() {
		return Major;
	}

	public void setMajor(String Major) {
		this.Major = Major;
	}
	
	public String getCreditLimit() {
		return CreditLimit;
	}

	public void setCreditLimit(String CreditLimit) {
		this.CreditLimit = CreditLimit;
	}
	
	public String getStudentNum() {
		return StudentNum;
	}

	public void setStudentNum(String StudentNum) {
		this.StudentNum = StudentNum;
	}
}