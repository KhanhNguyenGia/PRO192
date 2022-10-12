import java.util.Locale;
import java.util.Scanner;

public class Part2 {
	public static void main(String[] args) {
		boolean valid = true;
		// Use US locale for "." as decimal separator
		Locale.setDefault(new Locale("en", "US"));
		float num1 = 0, num2 = 0;
		String op;
		Scanner sc = new Scanner(System.in);
		do {
			try {
				System.out.print("Input the number 1: ");
				num1 = sc.nextFloat();
				valid = true;
			} catch (Exception e) {
				System.out.println("Invalid input");
				valid = false;
			}
		} while (!valid);

		do {
			try {
				System.out.print("Input the number 2: ");
				num2 = sc.nextFloat();
				valid = true;
			} catch (Exception e) {
				System.out.println("Invalid input");
				valid = false;
			}
		} while (!valid);
		System.out.print("input the operator (+-*/): ");
		sc = new Scanner(System.in);
		op = sc.nextLine();
		switch (op) {
			case "+":
				System.out.println("The result of " + num1 + " " + op + " " + num2 + " = " + (num1 + num2));
				break;
			case "-":
				System.out.println("The result of " + num1 + " " + op + " " + num2 + " = " + (num1 - num2));
				break;
			case "*":
				System.out.println("The result of " + num1 + " " + op + " " + num2 + " = " + (num1 * num2));
				break;
			case "/":
				if (num2 == 0) {
					System.out.println("Cannot divide by 0");
				} else {
					System.out.println("The result of " + num1 + " " + op + " " + num2 + " = " + String.format("%.2f", (num1 / num2)));
				}
				break;
			default:
				System.out.println("\"" + op + "\" is not supported");
		}
	}
}