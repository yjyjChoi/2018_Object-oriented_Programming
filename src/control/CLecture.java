package control;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

import model.MLecture;
import valueObject.VCLecture;
import valueObject.VMLecture;


public class CLecture {
	private MLecture mLecture;
	
	
	public CLecture() {
		this.mLecture = new MLecture();
	}

	public Vector<VCLecture> getData(String fileName) throws FileNotFoundException {//VCLecture가 아니라 VMLecture로 하면 나중에 하나 바꿀 때 프로그램을 처음부터 다시 해야됨/그니깐 처음부터 일반화시켜라
		Vector<VMLecture> vMLectures = this.mLecture.getData(fileName);
		Vector<VCLecture> vCLectures = new Vector<VCLecture>();
		
		for (VMLecture vMLecture: vMLectures) {//개수만큼 루핀을 돌림
			VCLecture vCLecture = new VCLecture();
			vCLecture.setId(vMLecture.getId());
			vCLecture.setName(vMLecture.getName());
			vCLecture.setProfessorName(vMLecture.getProfessorName());
			vCLecture.setCredit(vMLecture.getCredit());
			vCLecture.setTime(vMLecture.getTime());
			vCLectures.add(vCLecture);
		}
		return vCLectures;
	}

	public void setData(String fileName, Vector<VCLecture> vCLectures) throws IOException {
		Vector<VMLecture> vMLectures = new Vector<VMLecture>();
		
		for (VCLecture vCLecture: vCLectures) {//개수만큼 루핀을 돌림
			VMLecture vMLecture = new VMLecture();
			vMLecture.setId(vCLecture.getId());
			vMLecture.setName(vCLecture.getName());
			vMLecture.setProfessorName(vCLecture.getProfessorName());
			vMLecture.setCredit(vCLecture.getCredit());
			vMLecture.setTime(vCLecture.getTime());
			vMLectures.add(vMLecture);
		}
		this.mLecture.setData(fileName, vMLectures);
	}
}
