package dto;

import java.util.Scanner;

public class Vase extends Item {
	private int height;
	private String material;

	public Vase() {
		super();
		this.height = 0;
		this.material = "";
	}

	public Vase(int value, String creator, int height, String material) {
		super(value, creator);
		this.height = height;
		this.material = material;
	}

	public int getHeight() {
		return height;
	}

	public String getMaterial() {
		return material;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public void outputVase() {
		super.output();
		System.out.println("The height is: " + height);
		System.out.println("The material is: " + material);
	}

	public void inputVase() {
		super.input();
		boolean valid = true;
		Scanner sc = new Scanner(System.in);
		do {
			try {
				System.out.print("Enter the height: ");
				height = sc.nextInt();
				valid = true;
			} catch(Exception e) {
				valid = false;
				System.out.println("Invalid input");
			}
		} while (height <= 0 || !valid);
		do {
			sc = new Scanner(System.in);
			System.out.print("Enter the material: ");
			material = sc.nextLine();
		} while (material.isEmpty());
	}
}