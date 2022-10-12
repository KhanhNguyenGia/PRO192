package dto;

public abstract class LivingBeing {
	String name;

	public LivingBeing() {
		this.name = "";
	}

	public LivingBeing(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void useWater() {
		System.out.println("Use water");
	}

	public abstract void grow();

}