public class Car {
	private String color;
	private int enginePower;
	private boolean convertible;
	private boolean parkingBrake;

	// Constructors
	public Car() {
		this.color = "";
		this.enginePower = 0;
		this.convertible = false;
		this.parkingBrake = false;
	}

	public Car(String color, int enginePower, boolean convertible, boolean parkingBrake) {
		this.color = color;
		this.enginePower = enginePower;
		this.convertible = convertible;
		this.parkingBrake = parkingBrake;
	}

	// Getters
	public String getColor() {
		return color;
	}

	// Setters
	public void setColor(String color) {
		this.color = color;
	}

	public int getEnginePower() {
		return enginePower;
	}

	public void setEnginePower(int enginePower) {
		this.enginePower = enginePower;
	}

	public boolean getConvertible() {
		return convertible;
	}

	public void setConvertible(boolean convertible) {
		this.convertible = convertible;
	}

	public boolean getParkingBrake() {
		return parkingBrake;
	}

	public void setParkingBrake(boolean parkingBrake) {
		this.parkingBrake = parkingBrake;
	}

	// Other methods
	public void pressStartButton() {
		System.out.println("You have pressed the Start button");
	}

	public void pressAcceleratorButton() {
		System.out.println("You have pressed the Accelerator button");
	}

	public void output() {
		System.out.println("Color: " + color);
		System.out.println("Engine Power: " + enginePower);
		System.out.println("Convertible: " + convertible);
		System.out.println("Parking Brake: " + parkingBrake);
	}
}