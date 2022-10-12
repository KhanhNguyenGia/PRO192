package basic;

import mylib.Validation;

public class Course {
	final int MAX = 100;
	private final Student[] assignedStudents;
	private int code;
	private String name;
	private String credit;
	private int noStudent;

	public Course() {
		code = 0;
		name = "";
		credit = "";
		assignedStudents = new Student[MAX];
		noStudent = 0;
	}

	public Course(int code, String name, String credit) {
		this.code = code;
		this.name = name;
		this.credit = credit;
		assignedStudents = new Student[MAX];
		noStudent = 0;
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

	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	public void inputCourse() {
		boolean valid = true;
		do {
			try {
				code = (int) Validation.inputNumber("Code (1-100)", 1, 100);
				name = Validation.inputString("Name", "\\w+");
				credit = Validation.inputString("Credit", "\\w+");
				valid = true;
			} catch (Exception e) {
				valid = false;
				System.out.println("Invalid input");
			}
		} while (!valid);
	}

	public void outputCourse() {
		System.out.println(code + "-" + name + "-" + credit);
	}

	public boolean addStudent(Student student) {
		if (noStudent < MAX) {
			assignedStudents[noStudent] = student;
			noStudent++;
			student.addCourse(this);
			return false;
		}
		return true;
	}

	public void displayAssignedStudents() {
		if (noStudent == 0) {
			System.out.println("Student list is empty");
			return;
		}
		System.out.println("Assigned students");
		for (int i = 0; i < noStudent; i++) {
			assignedStudents[i].outputStudent();
		}
	}
}