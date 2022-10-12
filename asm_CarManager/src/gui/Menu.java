package gui;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	public int int_getChoice(ArrayList options) {
		Scanner sc = new Scanner(System.in);
		boolean valid = true;
		int response = 0;
		int n = options.size();
		do {
			try {
				for (int i = 0; i < n; i++) {
					System.out.println((i + 1) + ": " + options.get(i));
				}
				System.out.print("Please choose an option between 1 and " + n + ": ");
				response = sc.nextInt();
				valid = true;
			}catch(Exception e) {
				valid = false;
				System.out.println("Invalid option");
			}
		} while (!valid);
		return response;
	}

	public <E> E ref_getChoice(ArrayList<E> options) {
		int response = 0;
		int n = options.size();
		do {
			response = int_getChoice(options);
		} while (response < 0 || response > n);
		return options.get(response-1);
	}
}