package Brand;

import gui.Menu;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BrandList extends ArrayList<Brand> {
	public BrandList() {
		super();
	}

	public boolean loadFromFile(String filename) {
		try {
			File f = new File(filename);
			if (!f.exists()) {
				throw new FileNotFoundException();
			}
			if (!f.isFile()) {
				throw new Error("Filename is not a File");
			}
			FileReader fr = new FileReader(f);
			BufferedReader bf = new BufferedReader(fr);
			String details;
			while ((details = bf.readLine()) != null) {
				// Split the string at ":"
				StringTokenizer brt = new StringTokenizer(details, ":");
				// String before semi
				String brt_pre = brt.nextToken();
				double price = Double.parseDouble(brt.nextToken());
				StringTokenizer brt_details = new StringTokenizer(brt_pre, ",");
				String brandID = brt_details.nextToken().trim().toUpperCase();
				String brandName = brt_details.nextToken().trim().toUpperCase();
				String soundBrand = brt_details.nextToken().trim().toUpperCase();
				Brand brand = new Brand(brandID, brandName, soundBrand, price);
				this.add(brand);
			}
			bf.close();
			fr.close();
			return true;
		} catch (Exception e) {
//			System.out.println(e);
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean saveToFile(String filename) {
		try {
			File f = new File(filename);
			FileWriter fw = new FileWriter(f);
			PrintWriter pw = new PrintWriter(fw);
			for (Brand x : this) {
				pw.println(x);
			}
			pw.close();
			fw.close();
			return true;
		} catch (Exception e) {
//			System.out.println(e);
			return false;
		}
	}

	public int searchID(String brandID) {
		int n = this.size();
		for (int i = 0; i < n; i++) {
			if (this.get(i).getBrandID().equals(brandID)) {
				return i;
			}
		}
		return -1;
	}

	public Brand getUserChoice() {
		Menu mnu = new Menu();
		return (Brand) mnu.ref_getChoice(this);
	}

	public void addBrand() {
		String brandID = "", brandName = "", soundBrand = "";
		double price = 0.0;
		Scanner sc = null;
		boolean valid = true;
		do {
			sc = new Scanner(System.in);
			System.out.print("Enter brand's ID: ");
			brandID = sc.nextLine();
		} while (searchID(brandID) != -1 || brandID.equals(""));
		do {
			sc = new Scanner(System.in);
			System.out.print("Enter brand's name: ");
			brandName = sc.nextLine();
		} while (brandName.equals(""));
		do {
			sc = new Scanner(System.in);
			System.out.print("Enter sound's brand: ");
			soundBrand = sc.nextLine();
		} while (soundBrand.equals(""));
		do {
			try {
				sc = new Scanner(System.in);
				System.out.print("Enter the price: ");
				price = Double.parseDouble(sc.nextLine());
				valid = true;
			} catch (Exception e) {
				valid = false;
				System.out.println("Invalid pricing");
			}
		} while (price <= 0.0);
		Brand brand = new Brand(brandID, brandName, soundBrand, price);
		this.add(brand);
	}

	public void updateBrand() {
		String brandID = "";
		Scanner sc = new Scanner(System.in);
		boolean valid = true;
		System.out.print("Enter brand's ID: ");
		brandID = sc.nextLine();
		int pos = searchID(brandID);
		if (pos < 0) {
			System.out.println("Not found!");
			return;
		}
		String brandName = "", soundBrand = "";
		double price = 0.0;
		do {
			sc = new Scanner(System.in);
			System.out.print("Enter brand's name: ");
			brandName = sc.nextLine();
		} while (brandName.equals(""));
		do {
			sc = new Scanner(System.in);
			System.out.print("Enter sound's brand: ");
			soundBrand = sc.nextLine();
		} while (soundBrand.equals(""));
		do {
			try {
				sc = new Scanner(System.in);
				System.out.print("Enter the price: ");
				price = sc.nextDouble();
				valid = true;
			} catch (Exception e) {
				valid = false;
				System.out.println("Invalid pricing");
			}
		} while (price <= 0.0);
		Brand updatedBrand = this.get(pos);
		updatedBrand.setBrandName(brandName);
		updatedBrand.setSoundBrand(soundBrand);
		updatedBrand.setPrice(price);
	}

	public void listBrands() {
		for (Brand brand : this) {
			System.out.println(brand);
		}
	}
}