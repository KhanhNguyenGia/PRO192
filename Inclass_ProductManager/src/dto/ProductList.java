package dto;

import java.util.ArrayList;

public class ProductList {
	public final String filename = "ProductList.csv";
	private ArrayList<Product> list;

	public ProductList() {
		try {
			list = FileDAO.loadData(filename);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void displayProduct() {
		for (Product product : list) {
			System.out.println(product);
		}
	}

	public boolean addProduct(Product p) {
		list.add(p);
		try {
			FileDAO.writeData(filename, list);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean appendProduct(Product p) {
		list.add(p);
		try {
			FileDAO.appendData(filename, p);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public int findProductIndex(int id) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				return i;
			}
		}
		return -1;
	}

	public boolean updateProduct(Product p) {
		int fp = findProductIndex(p.getId());
		if (fp == -1) {
			System.out.println("Cannot find product with ID: " + p.getId());
			return false;
		}
		list.set(fp, p);
		try {
			FileDAO.writeData(filename, list);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}