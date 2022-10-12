package dto;

public class Animal extends LivingBeing {
	private String gender;

	public Animal() {
		super();
		this.gender = "";
	}

	public Animal(String name, String gender) {
		super(name);
		this.gender = gender;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public void grow() {
		System.out.println("Grow by food");
	}

	public void run() {

	}
}