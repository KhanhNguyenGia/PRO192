package HealthHospital;

import basic.Owner;
import basic.Pet;
import basic.Service;

import java.util.Scanner;

public class HealthHospital {
	public static void main(String[] args) {
		int choice = 0;
		Service s1 = null;
		Service s2 = null;
		Owner customer = new Owner();
		Pet pet = new Pet();
		do {
			System.out.println("1. Tao 2 service");
			System.out.println("2. Tao thong tin KH & Pet");
			System.out.println("3. Chon dich vu su dung");
			System.out.println("Nhap lua chon: ");
			Scanner sc = new Scanner(System.in);
			choice = sc.nextInt();
			switch (choice) {
				case 1 -> {
					s1 = new Service(1, "Cat mong", 100);
					s2 = new Service(2, "Tia long", 200);
					System.out.println("Done");
				}
				case 2 -> {
					customer.input();
					pet.input();
					if (customer.addPet(pet)) {
						System.out.println("Pet added successfully");
					} else {
						System.out.println("Failed to add pet");
					}
				}
				case 3 -> {
					System.out.println("1. Dich vu 1");
					System.out.println("1. Dich vu 2");
					System.out.println("Nhap dich vu [1/2]: ");
					int choice_2 = sc.nextInt();
					switch (choice_2) {
						case 1 -> {
							if (s1 != null)
								pet.addService(s1);
							else {
								System.out.println("Service 1 is not available");
							}
						}
						case 2 -> {
							if (s2 != null)
								pet.addService(s2);
							else {
								System.out.println("Service 2 is not available");
							}
						}
						default -> {
							System.out.println("Invalid input");
						}
					}
				}
			}

		} while (choice >= 0 && choice <= 3);
	}
}