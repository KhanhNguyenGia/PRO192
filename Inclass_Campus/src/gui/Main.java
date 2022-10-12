package gui;

import basic.Campus;
import basic.Course;
import basic.CourseList;
import basic.Student;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int c = 0;
		Campus campus = new Campus();
		CourseList courseList = new CourseList();
		do {
			System.out.println("1. Create Campus");
			System.out.println("2. Add a Student to Campus");
			System.out.println("3. Add a Course to Course List");
			System.out.println("4. Print Course List");
			System.out.println("5. Assign Course to a Student");
			System.out.println("6. Display Course List");
			System.out.println("0. Exit");
			Scanner sc = new Scanner(System.in);
			c = sc.nextInt();
			switch (c) {
				case 1 -> {
					campus.inputCampus();
				}
				case 2 -> {
					Student student = new Student();
					student.inputStudent();
					if (campus.addStudent(student)) {
						System.out.println("Student added");
					} else {
						System.out.println("Failed to add student");
					}
				}
				case 3 -> {
					Course course = new Course();
					course.inputCourse();
					if (courseList.addCourse(course)) {
						System.out.println("Course added");
					} else {
						System.out.println("Failed to add course");
					}
				}
				case 4 -> courseList.displayCourse();
				case 5 -> {
					System.out.println("Enter code course: ");
					int CourseCode = sc.nextInt();
					System.out.println("Enter id student: ");
					int StudentID = sc.nextInt();
					Course t = courseList.findCourse(CourseCode);
					Student s = campus.findStudent(StudentID);
					if (t != null && s != null) {
						s.addCourse(t);
						System.out.println("Course has been assigned");
					} else {
						System.out.println("Failed to find course or student");
					}
				}
				case 6 -> {
					campus.outputCampus();
					campus.displayALLStudent();
				}
				case 0 -> {
					System.out.println("Exiting...");
				}
				default -> {
					System.out.println("Invalid input");
				}
			}
		} while (c!= 0);
	}
}