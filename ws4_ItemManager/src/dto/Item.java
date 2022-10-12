package dto;

import java.util.Scanner;

public class Item {
	private int value;
	private String creator;

	public Item() {
		this.value = 0;
		this.creator = "";
	}

	public Item(int value, String creator) {
		this.value = value;
		this.creator = creator;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public void output() {
		System.out.println("The value of the item is: " + value);
		System.out.println("The creator is: " + creator);
	}

	public void input() {
		Scanner sc = new Scanner(System.in);
		boolean valid = true;
		do {
			try {
				System.out.print("Enter the value: ");
				value = sc.nextInt();
				valid = true;
			} catch (Exception e) {
				valid = false;
				System.out.println("Invalid input");
			}
		} while (value <= 0 || !valid);
		do {
			try {
				sc = new Scanner(System.in);
				System.out.print("Enter the creator: ");
				creator = sc.nextLine();
				valid = true;
			} catch (Exception e) {
				valid = false;
				System.out.println("Invalid input");
			}
		} while (creator.isEmpty() || !valid);
	}
}