package tester;

import dto.Laptop;
import dto.VNRemote;

public class Tester {
	public static void main(String[] args) {
		VNRemote.setTimer(5);
		Laptop obj = new Laptop();
		System.out.println(obj);
		obj.onLaptop();
	}
}