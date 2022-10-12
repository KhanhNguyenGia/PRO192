package dto;

import java.util.Scanner;

public class Inputter {
	public static Scanner sc = new Scanner(System.in);

	// Get an int between range
	public static int inputInt(String msg, int min, int max) {
		boolean valid = true;
		int data = 0;
		if (min > max) {
			int t = min;
			min = max;
			max = t;
		}
		do {
			try {
				System.out.print(msg);
				data = sc.nextInt();
				valid = true;
			} catch (Exception e) {
				valid = false;
				System.out.println("Invalid input");
			}
		} while (data < min || data > max || !valid);
		return data;
	}

	// Get a non-blank string
	public static String inputNonBlankStr(String msg) {
		String data = "";
		do {
			System.out.print(msg);
			data = sc.nextLine().trim();
		} while (data.length() == 0);
		return data;
	}

	// Get a string following a pattern
	public static String inputPattern(String msg, String pattern) {
		String data = "";
		do {
			System.out.print(msg);
			data = sc.nextLine().trim();
		} while (!data.matches(pattern));
		return data;
	}

	// Get a string with no condition
	public static String inputStr(String msg) {
		System.out.print(msg);
		String data = sc.nextLine().trim();
		return data;
	}

}