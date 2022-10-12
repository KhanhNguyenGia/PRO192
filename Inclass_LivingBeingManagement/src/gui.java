import dto.Food;
import dto.LivingBeing;
import dto.Lizard;
import dto.Venus;

import java.util.Scanner;

public class gui {
	public static void main(String[] args) {
		int choice = 0;
		LivingBeing obj = null;
		boolean valid = true;
		do {
			System.out.println("1. Create Lizard");
			System.out.println("2. Create Venus");
			System.out.println("3. Test Lizard/Venus");
			System.out.print("Enter choice: ");
			try {
				Scanner sc = new Scanner(System.in);
				choice = sc.nextInt();
				valid = true;
			} catch (Exception e) {
				System.out.println("Invalid input");
				valid = false;
			}
			switch (choice) {
				case 1 -> {
					obj = new Lizard("Komodo", "F");
					System.out.println("Done");
				}
				case 2 -> {
					obj = new Venus("Tropical Venus", 10, 2);
					System.out.println("Done");
				}
				case 3 -> {
					if (obj == null) {
						break;
					}
					obj.useWater();
					System.out.println("----------");
					obj.grow();
					System.out.println("----------");
					// Casting to an interface to invoke eatBug() for both class
					Food menu = (Food) obj;
					menu.eatBug();
				}
			}

		} while (!valid || choice <= 3 && choice >= 1);
	}
}