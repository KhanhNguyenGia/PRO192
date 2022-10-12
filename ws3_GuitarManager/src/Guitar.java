public class Guitar {
	private String serialNumber;
	private double price;
	private String builder;
	private String model;
	private String backWood;
	private String topWood;

	public Guitar() {
		this.serialNumber = null;
		this.price = 0.0;
		this.builder = null;
		this.model = null;
		this.backWood = null;
		this.topWood = null;
	}

	public Guitar(String serialNumber, double price, String builder, String model, String backWood, String topWood) {
		this.serialNumber = serialNumber;
		this.price = price;
		this.builder = builder;
		this.model = model;
		this.backWood = backWood;
		this.topWood = topWood;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public double getPrice() {
		return price;
	}

	public String getBuilder() {
		return builder;
	}

	public String getModel() {
		return model;
	}

	public String getBackWood() {
		return backWood;
	}

	public String getTopWood() {
		return topWood;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setBuilder(String builder) {
		this.builder = builder;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setBackWood(String backWood) {
		this.backWood = backWood;
	}

	public void setTopWood(String topWood) {
		this.topWood = topWood;
	}

	public void createSound() {
		System.out.println("Color: " + getSerialNumber());
		System.out.println("Price: " + getPrice());
		System.out.println("Builder: " + getBuilder());
		System.out.println("Model: " + getModel());
		System.out.println("Back Wood: " + getBackWood());
		System.out.println("Top Wood: " + getTopWood());
	}
}