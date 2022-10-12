package dto;

import java.util.Scanner;

public class Statue extends Item {
	private int weight;
	private String color;

	public Statue() {
		super();
		this.weight = 0;
		this.color = "";
	}

	public Statue(int value, String creator, int weight, String color) {
		super(value, creator);
		this.weight = weight;
		this.color = color;
	}

	public int getWeight() {
		return weight;
	}

	public String getColor() {
		return color;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void outputStatue() {
		super.output();
		System.out.println("The weight is: " + weight);
		System.out.println("The color is: " + color);
	}

	public void inputStatue() {
		boolean valid = true;
		super.input();
		Scanner sc = new Scanner(System.in);
		do {
			try {
				System.out.print("Enter the weight: ");
				weight = sc.nextInt();
				valid = true;
			}catch(Exception e) {
				valid = false;
				System.out.println("Invalid input");
			}
		} while (weight <= 0);
		do {
			sc = new Scanner(System.in);
			System.out.print("Enter the color: ");
			color = sc.nextLine();
		} while (color.isEmpty());
	}
}