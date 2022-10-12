package basic;

import mylib.Validation;

public class Student {
	final int MAX = 100;
	private final Course[] tolearnList;
	private int id;
	private String name;
	private String address;
	private String gender;
	private int noCourse;

	public Student() {

		tolearnList = new Course[MAX];
		noCourse = 0;
	}

	public Student(int id, String name, String address, String gender) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.gender = gender;
		tolearnList = new Course[MAX];
		noCourse = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void inputStudent() {
		boolean valid = true;
		do {
			try {
				id = (int) Validation.inputNumber("Id (1-100)", 1, 100);
				name = Validation.inputString("Name", "\\w+");
				address = Validation.inputString("Address", "\\w+");
				gender = Validation.inputString("Gender [F/M]", "[FM]$");
				valid = true;
			} catch (Exception e) {
				valid = false;
				System.out.println("Invalid input");

			}
		} while (!valid);
	}

	public void outputStudent() {
		System.out.println(id + "-" + name + "-" + gender + "-" + address);
	}

	public boolean addCourse(Course course) {
		if (noCourse < MAX) {
			tolearnList[noCourse] = course;
			noCourse++;
			return false;
		}
		return true;
	}

	public void displayToLearnList() {
		if (noCourse == 0) {
			System.out.println("Course list is empty");
			return;
		}
		for (int i = 0; i < noCourse; i++) {
			System.out.println("Course list:");
			tolearnList[i].outputCourse();
		}
	}
}