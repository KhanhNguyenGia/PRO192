package dto;

public class Orchid extends Plant {
	private double price;

	public Orchid() {
		super();
		this.price = 0.0;
	}

	public Orchid(String name, int year, double price) {
		super(name, year);
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}