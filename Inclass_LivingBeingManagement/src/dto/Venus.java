package dto;

public class Venus extends Plant implements Food {
	private int size;

	public Venus() {
		super();
		this.size = 0;
	}

	public Venus(String name, int year, int size) {
		super(name, year);
		this.size = size;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public void eatBug() {
		System.out.println("Eat " + Food.quantity + " bugs/week");
	}
}