package dto;

public class Laptop {
	private int id;
	private String name;
	private int price;
	private USBPort port;

	// Nested class
	class USBPort {
		private String brand;
		private String technology;

		public USBPort() {
			this.brand = "";
			this.technology = "";
		}

		public USBPort(String brand, String technology) {
			this.brand = brand;
			this.technology = technology;
		}

		public String getBrand() {
			return brand;
		}

		public void setBrand(String brand) {
			this.brand = brand;
		}

		public String getTechnology() {
			return technology;
		}

		public void setTechnology(String technology) {
			this.technology = technology;
		}
	}

	public Laptop() {
		this.id = 0;
		this.name ="";
		this.price = 0;
		this.port = new USBPort();
	}

	public Laptop(int id, String name, int price) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.port = new USBPort();
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

	public USBPort getPort() {
		return port;
	}

	public void onLaptop() {
		// anonymous class
		VNRemote remote = new VNRemote() {
			public void onDevice() {
				System.out.println("On Device");
			}
			public void offDevice() {
				System.out.println("Shutdown Device");
			}
		};
		remote.onDevice();
		System.out.println("Best wishes!");
	}

	@Override
	public String toString() {
		return id + ": " + name + ", " + price + ", " + getPort();
	}
}