package dto;

public class Plant extends LivingBeing {
	private int year;

	public Plant() {
		super();
		this.year = 0;
	}

	public Plant(String name, int year) {
		super(name);
		this.year = year;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public void grow() {
		System.out.println("Grow by light");
	}
}