package Basic;

import java.util.Scanner;

public class Student {
	private String id;
	private String name;
	private String gender;

	public Student() {
		this.id = "";
		this.name = "";
		this.gender = "";
	}

	public Student(String id, String name, String gender) {
		this.id = id;
		this.name = name;
		this.gender = gender;
	}

	public void inputStudent() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Input ID: ");
		id = sc.nextLine();
		System.out.print("Input name: ");
		name = sc.nextLine();
		System.out.print("Input gender: ");
		gender = sc.nextLine();
	}

	public void outputStudent() {
		System.out.println("ID: " + id);
		System.out.println("Name: " + name);
		System.out.println("Gender: " + gender);
	}

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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}