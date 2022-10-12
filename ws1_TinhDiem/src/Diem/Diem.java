package Diem;

import java.util.Scanner;

public class Diem {
	private double x;
	private double y;

	public Diem() {
		this.x = 0;
		this.y = 0;
	}

	public Diem(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public void inputPoint() {
		Scanner in = new Scanner(System.in);
		boolean valid = true;
		do {
			try {
				System.out.print("Nhap toa do x: ");
				x = Double.parseDouble(in.nextLine());
				valid = true;
			} catch (Exception e) {
				valid = false;
				System.out.println("Invalid input");
			}
		} while (!valid);
		do {
			try {
				System.out.print("Nhap toa do y: ");
				y = Double.parseDouble(in.nextLine());
				valid = true;
			} catch (Exception e) {
				valid = false;
				System.out.println("Invalid input");
			}
		} while (!valid);
	}

	public void outputPoint() {
		System.out.println("Toa do diem X, Y: " + x + ", " + y);
	}

	public double getDistance(Diem diem) {
		return Math.sqrt(Math.pow((x - diem.x), 2) + Math.pow((y - diem.y), 2));
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
}