package gui;

import java.util.Scanner;

import basic.Circle;

public class Tester {
	public static void main(String[] args) {
		int choice = 0;
		boolean valid = true;
		Circle c_1 = null;
		Circle c_2 = null;
		Scanner sc = null;
		do {
			try {
				System.out.println("1. Create two circle");
				System.out.println("2. Get circle relationship");
				System.out.println("3. Display circle 1");
				System.out.println("4. Display circle 2");
				System.out.println("0. Exit");
				System.out.print("Enter your choice: ");
				sc = new Scanner(System.in);
				choice = sc.nextInt();
				switch(choice) {
					case 1 -> {
						c_1 = new Circle();
						c_1.input();
						c_2 = new Circle();
						c_2.input();
					}
					case 2 -> {
						if (c_1 == null) {
							System.out.println("Circle 1 does not exist, please create the circle");
							break;
						}
						if (c_2 == null) {
							System.out.println("Circle 2 does not exist, please create the circle");
							break;
						}
						int relate = c_1.getRelationship(c_2);
						switch (relate) {
							case 0 -> {
								System.out.println("The two circles overlap");
							}
							case 1 -> {
								System.out.println("The two circle do not meet");
							}
							case 2 -> {
								System.out.println("The two circle meets");
							}
						}
					}
					case 3 -> {
						if (c_1 ==null) {
							System.out.println("Circle 1 does not exist, please create the circle");
							break;
						}
						c_1.output();
					}
					case 4 -> {
						if (c_2 ==null) {
							System.out.println("Circle 1 does not exist, please create the circle");
							break;
						}
						c_2.output();
					}
					case 0 -> {
						System.out.println("Exiting...");
					}
					default -> {
						System.out.println("Invalid choice");
					}
				}
				valid = true;
			} catch (Exception e) {
				System.out.println("Invalid choice");
				valid = false;
			}
		} while (!valid || choice != 0);
	}
}