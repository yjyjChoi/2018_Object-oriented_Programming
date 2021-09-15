package control;

import model.MPersonalInfo;
import valueObject.VCPersonalInfo;
import valueObject.VMPersonalInfo;


public class CPersonalInfo {
	private	MPersonalInfo mPersonalInfo;
	
	public CPersonalInfo() {
		
		this.mPersonalInfo = new MPersonalInfo();
	
	}
	public VCPersonalInfo getPersonalInfo(String ID) {
		// get data from entity
		VMPersonalInfo vMPersonalInfo = this.mPersonalInfo.getPersonalInfo(ID);
		// create control value object and set data from entity value object
		VCPersonalInfo vCPersonalInfo = new VCPersonalInfo();
		// ve에서 vc로 데이터 옮김
		vCPersonalInfo.setID(vMPersonalInfo.getID());
		vCPersonalInfo.setName(vMPersonalInfo.getName());
		vCPersonalInfo.setMajor(vMPersonalInfo.getMajor());
		vCPersonalInfo.setCreditLimit(vMPersonalInfo.getCreditLimit());
		vCPersonalInfo.setStudentNum(vMPersonalInfo.getStudentNum());
		return vCPersonalInfo;	
	}
}
