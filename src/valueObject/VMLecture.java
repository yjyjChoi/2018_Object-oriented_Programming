package valueObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class VMLecture {
	private String id;
	private String name;
	private String professorName;
	private String credit;
	private String time;


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getProfessorName() {
		return professorName;
	}


	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}


	public String getCredit() {
		return credit;
	}


	public void setCredit(String credit) {
		this.credit = credit;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public void readFromFile(Scanner scanner) {
		this.id = scanner.next();
		this.name = scanner.next();
		this.professorName = scanner.next();
		this.credit = scanner.next();
		this.time = scanner.next();
	}


	public void writeToFile(FileWriter fileWriter) throws IOException {//진짜 에러처리는 여기가 아니라 view에서
		fileWriter.write(this.id);
		fileWriter.write(" ");
		fileWriter.write(this.name);
		fileWriter.write(" ");
		fileWriter.write(this.professorName);
		fileWriter.write(" ");
		fileWriter.write(this.credit);
		fileWriter.write(" ");
		fileWriter.write(this.time);
		fileWriter.write(" ");
	}
}
