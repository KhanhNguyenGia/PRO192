package basic;

import mylib.Validation;

public class Campus {
	final int MAX = 100;
	private final Student[] studentList;
	private int noOfStudents;
	private int code;
	private String name;
	private String address;

	public Campus() {
		code = 0;
		name = "";
		address = "";
		studentList = new Student[MAX];
		noOfStudents = 0;
	}

	public Campus(int code, String name, String address) {
		this.code = code;
		this.name = name;
		this.address = address;
		studentList = new Student[MAX];
		noOfStudents = 0;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void inputCampus() {
		boolean valid = true;
		do {
			try {
				code = (int) Validation.inputNumber("Code (1-100)", 1, 100);
				name = Validation.inputString("Name", "\\w+");
				address = Validation.inputString("Address", "\\w+");
				valid = true;
			} catch (Exception e) {
				valid = false;
				System.out.println("Invalid input");
			}
		} while (!valid);
	}

	public void outputCampus() {
		System.out.println(code + "-" + name + "-" + address);
	}

	public boolean addStudent(Student student) {
		if (noOfStudents < MAX) {
			studentList[noOfStudents] = student;
			noOfStudents++;
			return true;
		}
		return false;
	}

	public void displayALLStudent() {
		if (noOfStudents == 0) {
			System.out.println("Student list is empty");
			return;
		}
		System.out.println("Student list");
		for (int i = 0; i < noOfStudents; i++) {
			studentList[i].displayToLearnList();

		}
	}

	public Student findStudent(int id) {
		for (int i = 0; i < noOfStudents; i++) {
			if (studentList[i].getId() == id) {
				return studentList[i];
			}
		}
		return null;
	}

}