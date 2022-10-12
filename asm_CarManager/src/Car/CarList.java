package Car;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

import Brand.Brand;
import Brand.BrandList;
import gui.Menu;

public class CarList extends ArrayList<Car> {
	private BrandList brandList;

	public CarList(BrandList bList) {
		super();
		this.brandList = bList;
	}

	@Override
	public String toString() {
		return "";
	}

	public boolean loadFromFile(String filename) {
		try {
			File f = new File(filename);
			if (!f.exists()) {
				throw new FileNotFoundException();
			}
			FileReader fr = new FileReader(f);
			BufferedReader bf = new BufferedReader(fr);
			String details;
			while ((details = bf.readLine()) != null) {
				StringTokenizer brt = new StringTokenizer(details, ",");
				String carID = brt.nextToken().trim().toUpperCase();
				String brandID = brt.nextToken().trim().toUpperCase();
				String color = brt.nextToken().trim().toUpperCase();
				String frameID = brt.nextToken().trim().toUpperCase();
				String engineID = brt.nextToken().trim().toUpperCase();
				int pos = brandList.searchID(brandID);
				Brand b = brandList.get(pos);
				Car c = new Car(carID, b, color, frameID, engineID);
				this.add(c);
			}
			bf.close();
			fr.close();
			return true;
		} catch (Exception e) {
//			System.out.println(e);
			System.out.println("File does not exist");
			return false;
		}
	}

	public boolean saveToFile(String filename) {
		try {
			File f = new File(filename);
			FileWriter fw = new FileWriter(f);
			PrintWriter pw = new PrintWriter(fw);
			for (Car x : this) {
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

	public int searchID(String bID) {
		int n = this.size();
		for (int i = 0; i < n; i++) {
			if (this.get(i).getBrand().getBrandID().equals(bID)) {
				return i;
			}
		}
		return -1;
	}

	public int searchFrame(String fID) {
		int n = this.size();
		for (int i = 0; i < n; i++) {
			if (this.get(i).getFrameID().equals(fID)) {
				return i;
			}
		}
		return -1;
	}

	public int searchEngine(String eID) {
		int n = this.size();
		for (int i = 0; i < n; i++) {
			if (this.get(i).getEngineID().equals(eID)) {
				return i;
			}
		}
		return -1;
	}

	public void addCar() {
		Scanner sc = null;
		String color = "", frameID = "", engineID = "", carID = "";
		String framePattern = "F\\d{4}", enginePattern = "E\\d{4}";
		do {
			sc = new Scanner(System.in);
			System.out.print("Enter car's ID: ");
			carID = sc.nextLine();
		} while (carID.equals("") || searchID(carID) != -1);
		Menu menu = new Menu();
		Brand b = (Brand) menu.ref_getChoice(brandList);
		do {
			sc = new Scanner(System.in);
			System.out.print("Enter color: ");
			color = sc.nextLine();
		} while (color.equals(""));
		do {
			sc = new Scanner(System.in);
			System.out.print("Enter frame's ID: ");
			frameID = sc.nextLine();
		} while (frameID.equals("") || !frameID.matches(framePattern) || searchFrame(frameID) != -1);
		do {
			sc = new Scanner(System.in);
			System.out.print("Enter engine's ID: ");
			engineID = sc.nextLine();
		} while (engineID.equals("") || !engineID.matches(enginePattern) || searchEngine(engineID) != -1);
		Car car = new Car(carID, b, color, frameID, engineID);
		this.add(car);
	}

	public void printBasedBrandName() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the brand's name to search: ");
		String partName = sc.nextLine();
		int n = this.size();
		int count = 0;
		for (Car c : this) {
			if (c.getBrand().getBrandName().contains(partName)) {
				System.out.println(c.screenString());
				count++;
			}
		}
		if (count == 0) {
			System.out.println("No car is detected");
		}
	}

	public boolean removeCar() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the ID to remove");
		String removedID = sc.nextLine();
		int pos = searchID(removedID);
		if (pos < 0) {
			System.out.println("Not found!");
			return false;
		}
		this.remove(pos);
		return true;
	}

	public boolean updateCar() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the ID to update");
		String removedID = sc.nextLine();
		int pos = searchID(removedID);
		if (pos < 0) {
			System.out.println("Not found!");
			return false;
		}
		String color = "", frameID = "", engineID = "";
		String framePattern = "F\\d{4}", enginePattern = "E\\d{4}";
		Menu menu = new Menu();
		Brand b = (Brand) menu.ref_getChoice(brandList);
		do {
			sc = new Scanner(System.in);
			System.out.print("Enter color: ");
			color = sc.nextLine();
		} while (color.equals(""));
		do {
			sc = new Scanner(System.in);
			System.out.print("Enter frame's ID: ");
			frameID = sc.nextLine();
		} while (frameID.equals("") || !frameID.matches(framePattern) || searchFrame(frameID) != -1);
		do {
			sc = new Scanner(System.in);
			System.out.print("Enter engine's ID: ");
			engineID = sc.nextLine();
		} while (engineID.equals("") || !engineID.matches(enginePattern) || searchEngine(engineID) != -1);
		Car c = this.get(pos);
		c.setBrand(b);
		c.setColor(color);
		c.setFrameID(frameID);
		c.setEngineID(engineID);
		return true;
	}

	public void listCars() {
		Collections.sort(this);
		System.out.println("Printing car in ascending order of brand names");
		for (Car c : this) {
			System.out.println(c.screenString());
		}
	}
}