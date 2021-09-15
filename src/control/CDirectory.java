package control;

import java.util.Vector;

import model.MDirectory;
import valueObject.VCDirectory;
import valueObject.VMDirectory;

public class CDirectory {
	private MDirectory mDirectory;
	private Vector<VCDirectory> vCDirectories;
	
	public CDirectory() {
		this.mDirectory = new MDirectory();
	}

	public Vector<VCDirectory> getData(String fileName) {
		Vector<VMDirectory> vMDirectories = this.mDirectory.getData(fileName);
		this.vCDirectories = new Vector<VCDirectory>();
		
		for (VMDirectory vMDirectory: vMDirectories) {//개수만큼 루핀을 돌림
			VCDirectory vCDirectory = new VCDirectory();
			vCDirectory.setId(vMDirectory.getId());
			vCDirectory.setText(vMDirectory.getText());
			vCDirectory.setFileName(vMDirectory.getFileName());
			this.vCDirectories.add(vCDirectory);
		}
		return this.vCDirectories;
	}
}
