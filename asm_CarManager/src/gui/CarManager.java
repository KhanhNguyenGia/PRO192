package gui;

import Brand.Brand;
import Brand.BrandList;
import Car.CarList;

import java.util.ArrayList;
import java.util.Scanner;

public class CarManager {
	public static void main(String[] args) {
		Scanner sc = null;
		ArrayList<String> ops = new ArrayList<String>();
		ops.add("List all brands");
		ops.add("Add a new brand");
		ops.add("Search a brand based on its IDs");
		ops.add("Update a brand");
		ops.add("Save brands to the file, named brands.txt");
		ops.add("List all cars in ascending orders of brand names");
		ops.add("List cars based on a part of an input brand name");
		ops.add("Add a car");
		ops.add("Remove a car based on its ID");
		ops.add("Update a car based on its ID");
		ops.add("Save  cars to file, named cars.txt");
		ops.add("Others to exit");
		BrandList brandList = new BrandList();
		brandList.loadFromFile("brands.txt");
		CarList carList = new CarList(brandList);
		carList.loadFromFile("cars.txt");
		int choice = 0;
		Menu menu = new Menu();
		do {
			choice = menu.int_getChoice(ops);
			switch (choice) {
				case 1 -> brandList.listBrands();
				case 2 -> brandList.addBrand();
				case 3 -> {
					sc = new Scanner(System.in);
					System.out.print("Enter the ID to search: ");
					String searchID = sc.nextLine();
					int pos = brandList.searchID(searchID);
					if (pos <= 0) {
						System.out.println("Not found!");
						break;
					}
					System.out.println(brandList.get(pos));
				}
				case 4 -> brandList.updateBrand();
				case 5 -> brandList.saveToFile("brands.txt");
				case 6 -> carList.listCars();
				case 7 -> carList.printBasedBrandName();
				case 8 -> carList.addCar();
				case 9 -> carList.removeCar();
				case 10 -> carList.updateCar();
				case 11 -> carList.saveToFile("cars.txt");
				default -> System.out.println("Exiting...");
			}
		} while (choice > 0 && choice <= ops.size());
	}
}