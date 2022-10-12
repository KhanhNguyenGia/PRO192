package dto;

public class Product {
	private int id;
	private String name;
	private int price;
	private String unit;

	public Product() {
		id = 0;
		name = "";
		price = 0;
		unit = "";
	}

	public Product(int id, String name, int price, String unit) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.unit = unit;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Override
	public String toString() {
		return id + "," + name + "," + price + "," + unit;
	}


}