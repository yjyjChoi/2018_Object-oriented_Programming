package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import global.Constants.EDataFileName;
import valueObject.VMDirectory;

public class MDirectory {
	private Vector<VMDirectory> vMDirectories;//∫¿≈ı
	
	public MDirectory() {
		this.vMDirectories = new Vector<VMDirectory>();
	}

	public Vector<VMDirectory> getData(String fileName) {
		try { 
			this.vMDirectories.clear();//∫¿≈ı ≈¨∏ÆæÓ
			File file = new File(EDataFileName.path.getString() + fileName);
			Scanner scanner = new Scanner(file);
			
			while(scanner.hasNext()) {
				VMDirectory vMDirectory = new VMDirectory();//¡¯¬• ¥„¿ª ±◊∏© != ∫¿≈ı
				vMDirectory.readFromFile(scanner);
				this.vMDirectories.add(vMDirectory);
			}
			scanner.close();
			return this.vMDirectories;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
