package Main;

import java.util.Scanner;

import PhanSo.PhanSo;

public class Main {

	public static void main(String[] args) {
		int c = 0;
		Scanner sc = new Scanner(System.in);
		PhanSo ps_1 = null;
		PhanSo ps_2 = null;
		do {
			System.out.println("1. Nhap 2 phan so");
			System.out.println("2. Xuat 2 phan so");
			System.out.println("3. Cong 2 phan so");
			System.out.println("4. Tru 2 phan so");
			System.out.println("5. Nhan 2 phan so");
			System.out.println("6. Chia 2 phan so");
			System.out.println("0. Exit");
			System.out.print("Chon: ");
			c = sc.nextInt();
			switch(c) {
				case 1:
					ps_1 = new PhanSo();
					ps_2 = new PhanSo();
					ps_1.nhap();
					ps_2.nhap();
					break;
				case 2:
					if (ps_1 != null) {
						ps_1.xuat();
					} else {
						System.out.println("Phan so 1 khong ton tai");
					}
					if (ps_2 != null) {
						ps_2.xuat();
					} else {
						System.out.println("Phan so 2 khong ton tai");
					}
					break;
				case 3:
					if (ps_1 == null || ps_2 == null) {
						System.out.println("Phan so khong ton tai");
					} else {
						System.out.print("Cong hai phan so: ");
						ps_1.cong(ps_2).xuat();
					}
					break;
				case 4:
					if (ps_1 == null || ps_2 == null) {
						System.out.println("Phan so khong ton tai");
					} else {
						System.out.print("Tru hai phan so: ");
						ps_1.tru(ps_2).xuat();
					}
					break;
				case 5:
					if (ps_1 == null || ps_2 == null) {
						System.out.println("Phan so khong ton tai");
					} else {
						System.out.print("Nhan hai phan so: ");
						ps_1.nhan(ps_2).xuat();
					}
					break;
				case 6:
					if (ps_1 == null || ps_2 == null) {
						System.out.println("Phan so khong ton tai");
					} else {
						System.out.print("Chia hai phan so: ");
						ps_1.chia(ps_2).xuat();
					}
					break;
				case 0:
					System.out.println("Exiting...");
					break;
				default:
					System.out.println("Lua chon khong ton tai");
			}
		} while (c != 0);
	}
}