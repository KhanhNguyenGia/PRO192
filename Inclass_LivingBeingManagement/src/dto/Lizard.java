package dto;

public class Lizard extends Animal implements Food {
	public Lizard() {
		super();
	}

	public Lizard(String name, String gender) {
		super(name, gender);
	}

	@Override
	public void eatBug() {
		System.out.println("Eat " + Food.quantity + " bugs/day");
	}
}