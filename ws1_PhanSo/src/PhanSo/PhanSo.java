package PhanSo;

import java.util.Scanner;

public class PhanSo {
	private int tu;
	private int mau;

	public PhanSo() {
		this.tu = 0;
		this.mau = 0;
	}

	public PhanSo(int tu, int mau) {
		this.tu = tu;
		this.mau = mau;
	}

	public int getTu() {
		return tu;
	}

	public void setTu(int tu) {
		this.tu = tu;
	}

	public int getMau() {
		return mau;
	}

	public void setMau(int mau) {
		if (mau == 0) {
			System.out.println("Mau khong duoc bang khong");
			return;
		}
		this.mau = mau;
	}

	public void nhap() {
		Scanner in = new Scanner(System.in);
		boolean valid = true;
		do {
			try {
				System.out.print("Enter tu so: ");
				tu = Integer.parseInt(in.nextLine());
				valid = true;
			} catch (Exception e) {
				valid = false;
				System.out.println("Invalid input");
			}
		} while (!valid);
		do {
			try {
				System.out.print("Enter mau so: ");
				mau = Integer.parseInt(in.nextLine());
				valid = true;
			} catch (Exception e) {
				valid = false;
				System.out.println("Invalid input");
			}
		} while (mau == 0 || !valid) ;
	}

	public void xuat() {
		System.out.println(tu + " / " + mau);
	}

	public PhanSo cong(PhanSo ps) {
		PhanSo temp = new PhanSo();
		temp.tu = tu * ps.mau + ps.tu * mau;
		temp.mau = mau * ps.mau;
		return temp;
	}

	public PhanSo tru(PhanSo ps) {
		PhanSo temp = new PhanSo();
		temp.tu = tu * ps.mau - ps.tu * mau;
		temp.mau = mau * ps.mau;
		return temp;
	}

	public PhanSo nhan(PhanSo ps) {
		PhanSo temp = new PhanSo();
		temp.tu = tu * ps.tu;
		temp.mau = mau * ps.mau;
		return temp;
	}

	public PhanSo chia(PhanSo ps) {
		PhanSo temp = new PhanSo();
		temp.tu = tu * ps.mau;
		temp.mau = mau * ps.tu;
		return temp;
	}

}