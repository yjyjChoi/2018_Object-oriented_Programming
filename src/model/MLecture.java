package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import global.Constants.EDataFileName;
import valueObject.VMLecture;

public class MLecture {
private Vector<VMLecture> vMLectures;//∫¿≈ı
	
	public MLecture() {
		this.vMLectures = new Vector<VMLecture>();
	}

	public Vector<VMLecture> getData(String fileName) throws FileNotFoundException {
		this.vMLectures.clear();//∫¿≈ı ≈¨∏ÆæÓ
		File file = new File(EDataFileName.path.getString() + fileName);
		Scanner scanner = new Scanner(file);
			
		while(scanner.hasNext()) {
			VMLecture vMLecture = new VMLecture();//¡¯¬• ¥„¿ª ±◊∏© != ∫¿≈ı
			vMLecture.readFromFile(scanner);
			this.vMLectures.add(vMLecture);
		}
		scanner.close();
		return this.vMLectures;
	}

	public void setData(String fileName, Vector<VMLecture> vMLectures) throws IOException {
		File file = new File(EDataFileName.path.getString() + fileName);
		FileWriter fileWriter = new FileWriter(file);
		for (VMLecture vMLecture : vMLectures) {
			vMLecture.writeToFile(fileWriter);
		}
		fileWriter.close();
	}
}
