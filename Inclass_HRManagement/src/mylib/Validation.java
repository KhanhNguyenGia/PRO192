package mylib;

import java.util.Scanner;

public class Validation {

	public static double inputNumber(String msg, double min, double max) throws Exception {
		Scanner s = new Scanner(System.in);
		System.out.println(msg);
		double number = s.nextDouble();
		if (number < min || number > max) {
			throw new Exception();
		}
		return number;
	}

	public static String inputString(String msg, String pattern) throws Exception {
		Scanner s = new Scanner(System.in);
		System.out.println(msg);
		String str = s.nextLine();
		if (!str.matches(pattern)) {
			throw new Exception();
		}
		return str;
	}
}