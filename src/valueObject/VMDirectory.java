package valueObject;

import java.util.Scanner;

public class VMDirectory {
	private String id;
	private String text;
	private String fileName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void readFromFile(Scanner scanner) {
		this.id = scanner.next();
		this.text = scanner.next();
		this.fileName = scanner.next();
	}
}
