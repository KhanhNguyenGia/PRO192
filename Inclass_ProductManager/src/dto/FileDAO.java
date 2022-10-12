package dto;

import java.io.*;
import java.util.ArrayList;

public class FileDAO {

	//doc file va tra ve arraylist cac product
	public static ArrayList<Product> loadData(String filename) throws Exception {
		//open file
		File tmp = new File(filename);
		if (!tmp.exists()) throw new Error("File does not exist");
		if (!tmp.isFile()) throw new Error("Provided filename is not a File");
		FileReader f = new FileReader(filename);
		BufferedReader bf = new BufferedReader(f);
		//read file
		ArrayList<Product> list = new ArrayList<>();
		while (bf.ready()) {
			String s = bf.readLine();
			//convert s to obj
			String[] arr = s.split(",");
			if (arr.length == 4) {
				Product p = new Product(Integer.parseInt(arr[0]), arr[1], Integer.parseInt(arr[2]), arr[3]);
				list.add(p);
			}
		}
		f.close();
		bf.close();
		return list;
	}

	// Append data by rewriting the entire file
	public static void writeData(String filename, ArrayList<Product> list) throws Exception {
		if (list == null || list.size() <= 0) return;
		PrintWriter w = new PrintWriter(filename);
		for (Product product : list) {
			w.println(product.toString());
		}
		w.close();
	}

	// Append data using binary write
	public static void appendData(String filename, Product product) throws Exception {
		FileOutputStream f = new FileOutputStream(filename,true);
		OutputStreamWriter w = new OutputStreamWriter(f);
		w.write(product.toString());
		w.close();
		f.close();
	}
}