package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import global.Constants.EDataFileName;
import valueObject.VMPersonalInfo;

public class MPersonalInfo {

	public VMPersonalInfo getPersonalInfo(String ID) {
		VMPersonalInfo vMPersonalInfo = new VMPersonalInfo();
		
		try { 
		
			File file = new File(EDataFileName.path.getString() + EDataFileName.personalInfo.getString());
			Scanner scanner = new Scanner(file);
			
			while(scanner.hasNext()) {
			
				vMPersonalInfo.readFromFile(scanner);
				if (vMPersonalInfo.getID().equals(ID)) {
		
					return vMPersonalInfo;
		
				}
			}
			scanner.close();
	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	
		return null;

	}

}

