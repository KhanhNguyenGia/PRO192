import java.util.Scanner;

public class Part3 {
	public static void main(String[] args) {
		String[] list = new String[10];
		System.out.println("Enter the students' name: ");
		for (int i = 0; i < 10; i++) {
			System.out.print((i+1) + ": ");
			Scanner sc = new Scanner(System.in);
			list[i] = sc.nextLine();
		}
		for (int i = 0; i < 10; i++) {
			// Extract the first letter using substring(0,1) and call toUpperCase()
			// Combine the first letter with the rest using String concatenation
			list[i] = list[i].substring(0,1).toUpperCase() + list[i].substring(1);
		}
		System.out.println("Students' name after capitalizing: ");
		for (int i = 0; i < 10; i++) {
			System.out.println((i+1) + ": " + list[i]);
		}
	}
}