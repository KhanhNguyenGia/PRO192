package dto;

import java.util.Scanner;

public class Painting extends Item {
	private int height;
	private int width;
	private boolean isWaterColor;
	private boolean isFramed;

	public Painting() {
		super();
		this.height = 0;
		this.width = 0;
		this.isWaterColor = false;
		this.isFramed = false;
	}

	public Painting(int value, String creator, int height, int width, boolean isWatercolor, boolean isFramed) {
		super(value, creator);
		this.height = height;
		this.width = width;
		this.isWaterColor = isWatercolor;
		this.isFramed = isFramed;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public boolean getWaterColor() {
		return isWaterColor;
	}

	public void setWaterColor(boolean waterColor) {
		this.isWaterColor = waterColor;
	}

	public boolean getFramed() {
		return isFramed;
	}

	public void setFramed(boolean framed) {
		this.isFramed = framed;
	}

	public void outputPainting() {
		super.output();
		System.out.println("The width is: " + width);
		System.out.println("The height is: " + height);
		System.out.println("Watercolor: " + isWaterColor);
		System.out.println("Framed: " + isFramed);
	}

	public void inputPainting() {
		boolean valid = true;
		super.input();
		Scanner sc = new Scanner(System.in);
		do {
			try {
				System.out.print("Enter the width: ");
				width = sc.nextInt();
				valid = true;
			} catch (Exception e) {
				valid = false;
				System.out.println("Invalid input");
			}
		} while (width <= 0 || !valid);
		do {
			try {
				System.out.print("Enter the height: ");
				height = sc.nextInt();
				valid = true;
			} catch (Exception e) {
				valid = false;
				System.out.println("Invalid input");
			}
		} while (height <= 0 || !valid);
		do {
			try {
				sc = new Scanner(System.in);
				System.out.print("Is the painting watercolor?: ");
				isWaterColor = sc.nextBoolean();
				valid = true;
			} catch (Exception e) {
				valid = false;
				System.out.println("Invalid input");
			}
		} while (!valid);
		do {
			try {
				sc = new Scanner(System.in);
				System.out.print("Is the painting framed?: ");
				isFramed = sc.nextBoolean();
				valid = true;
			} catch (Exception e) {
				valid = false;
				System.out.println("Invalid input");
			}
		} while (!valid);
	}
}