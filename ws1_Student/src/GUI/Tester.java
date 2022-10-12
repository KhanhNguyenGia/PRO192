package GUI;

import Basic.Student;

import java.util.Scanner;

public class Tester {
	public static void main(String[] args) {
		int c = 0;
		Scanner sc = new Scanner(System.in);
		Student s = null;
		Student s_2 = null;
		do {
			System.out.println("1. Enter student");
			System.out.println("2. Display student");
			System.out.println("0. Exit");
			System.out.print("Select: ");
			c = sc.nextInt();
			switch(c) {
				case 1:
					s = new Student();
					s_2 = new Student("SE170408", "Khanh", "Male");
					s.inputStudent();
					break;
				case 2:
					if (s != null) {
						System.out.println("Student 1: ");
						s.outputStudent();
					} else {
						System.out.println("Student has not been created");
					}
					if (s_2 != null) {
						System.out.println("Student 2: ");
						s_2.outputStudent();
					} else {
						System.out.println("Student has not been created");
					}
					break;
				case 0:
					System.out.println("Exiting...");
					break;
				default:
					System.out.println("Invalid choice");
			}
		} while (c != 0);
	}
}