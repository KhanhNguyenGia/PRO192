package basic;

import java.util.Scanner;

public class Circle {
	private Point middle;
	private double radius;

	public Circle() {
		this.middle = new Point();
		this.radius = 0;
	}

	public Circle(Point middle, double radius) {
		this.middle = middle;
		this.radius = radius;
	}

	public Point getMiddle() {
		return middle;
	}

	public void setMiddle(Point middle) {
		this.middle = middle;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public void input() {
		boolean valid = true;
		Scanner sc = null;
		do {
			try {
				sc = new Scanner(System.in);
				middle.input();
				System.out.print("Enter the radius of the circle: ");
				radius = sc.nextDouble();
				valid = true;
			} catch (Exception e) {
				System.out.println("Invalid input");
				valid = false;
			}
		} while (!valid);
	}

	public void output() {
		middle.output();
		System.out.println(", Circle radius: " + radius);
	}

	public int getRelationship(Circle C) {
		double d = middle.getDistance(C.middle);
		if (d == 0) {
			return 0; // Overlap
		}
		if (d > radius + C.radius) {
			return 1; // Does not meet
		}
		return 2; // Meet
	}
}