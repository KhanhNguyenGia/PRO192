package gui;

import java.util.Scanner;

public class Menu {
	public static int getChoice(Object[] options) {
		boolean valid = true;
		int choice = 0;
		Scanner sc = null;
		do {
			try {
				for (int i = 0; i < options.length; i++) {
					System.out.println((i + 1) + "-" + options[i]);
				}
				System.out.print("Choose 1.." + options.length + ": ");
				sc = new Scanner(System.in);
				choice = sc.nextInt();
				valid = true;
			} catch (Exception e) {
				valid = false;
				System.out.println("Invalid option");
			}
		} while (!valid);
		return choice;
	}
}