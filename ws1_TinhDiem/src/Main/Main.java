package Main;
import Diem.Diem;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int c = 0;
		Diem diem_1 = null, diem_2 = null;
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("1. Nhap 2 diem");
			System.out.println("2. Xuat 2 diem");
			System.out.println("3. Tinh khoangg cach");
			System.out.println("0. Exit");
			System.out.print("Nhap lua chon: ");
			c = sc.nextInt();
			switch (c) {
				case 1:
					diem_1 = new Diem(0.0,0.0);
					diem_2 = new Diem();
					diem_2.inputPoint();
					break;
				case 2:
					if (diem_1 != null)
						diem_1.outputPoint();
					else {
						System.out.println("Em yeu co");
					}
					if (diem_2 != null)
						diem_2.outputPoint();
					else {
						System.out.println("Em yeu co");
					}
					break;
				case 3:
					if (diem_1 != null && diem_2 != null) {
						double d = diem_1.getDistance(diem_2);
						System.out.println("Distance between two points is: " + String.format("%.2f",d));
					}
					else {
						System.out.println("Em yeu co");
					}
					break;
				case 0:
					System.out.println("Exiting");
					break;
				default:
					System.out.println("Invalid option");
			}
		} while (c != 0);
	}
}