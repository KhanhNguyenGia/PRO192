package dto;

public class Colony extends Organization {
	private String place;

	public Colony() {
		super();
		this.place = "";
	}

	public Colony(int value, String place) {
		super(value);
		this.place = place;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	@Override
	public void communicateByTool() {
		System.out.println("The colony communicate by sound");
	}

	public void grow() {
		System.out.println("An annual cycle of growth that begins in spring");
	}

	public void reproduce() {
		System.out.println("Colony can reproduce itself through a process");
	}

	@Override
	public String toString() {
		return "The colony's size is " + super.getSize() + ", the colony's place is " + place;
	}
}