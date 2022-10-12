package dto;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	public static int getChoice(ArrayList options) {
		boolean valid = true;
		int choice = 0;
		Scanner sc = null;
		do {
			try {
				for (int i = 0; i < options.size(); i++) {
					System.out.print((i + 1) + "-" + options.get(i));
				}
				System.out.print("Choose 1.." + options.size() + ": ");
				sc = new Scanner(System.in);
				choice = sc.nextInt();
				valid = true;
			} catch (Exception e) {
				valid = false;
				System.out.println("Invalid input");
			}
		} while (!valid);
		return choice;
	}

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
				System.out.println("Invalid input");
			}
		} while (!valid);
		return choice;
	}
}