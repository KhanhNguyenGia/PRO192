package gui;

import dto.Product;
import dto.ProductList;

import java.util.Scanner;

public class ProductManager {
	public static void main(String[] args) {
		ProductList x = new ProductList();
		int choice = 0;
		boolean valid = true;
		do {
			try {
				System.out.println("1. add product");
				System.out.println("2. display product");
				System.out.println("3. update product");
				Scanner sc = new Scanner(System.in);
				choice = sc.nextInt();
				valid = true;
			} catch (Exception e) {
				valid = false;
				System.out.println("Invalid input");
			}
		} while (!valid || choice > 3 || choice < 1);
		switch (choice) {
			case 1 -> {
				int id, price;
				String name, unit;
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter id:");
				id = sc.nextInt();
				sc = new Scanner(System.in);
				System.out.println("Enter name:");
				name = sc.nextLine();
				sc = new Scanner(System.in);
				System.out.println("Enter price:");
				price = sc.nextInt();
				sc = new Scanner(System.in);
				System.out.println("Enter unit:");
				unit = sc.nextLine();
				Product p = new Product(id, name, price, unit);
				x.addProduct(p);
			}
			case 2 -> x.displayProduct();
			case 3 -> {
				do {
					try {

						valid = true;
					} catch (Exception e) {
						valid = false;
					}
				} while (!valid);
			}
			default -> throw new AssertionError();
		}
	}
}