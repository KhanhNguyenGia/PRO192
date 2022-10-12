package basic;

import java.util.Scanner;

public class Point {
	private double x;
	private double y;

	public Point() {
		this.x = 0.0;
		this.y = 0.0;
	}

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
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

	public void input() {
		boolean valid = true;
		Scanner sc = null;
		do {
			try {
				sc = new Scanner(System.in);
				System.out.print("Please enter the x coordinate: ");
				x = sc.nextDouble();
				System.out.print("Please enter the y coordinate: ");
				y = sc.nextDouble();
				valid = true;
			} catch (Exception e) {
				System.out.println("Invalid input");
				valid = false;
			}
		} while (!valid);
	}

	public void output() {
		System.out.format("The coordinate is: %.2f, %.2f", x, y);
	}

	public double getDistance(Point P) {
		return Math.sqrt(Math.pow(x - P.x, 2) + Math.pow(y - P.y, 2));
	}
}