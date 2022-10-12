public class Tester {
	public static void main(String[] args) {
		Car c = new Car();
		c.pressStartButton();
		c.pressAcceleratorButton();
		c.output();

		Car c2 = new Car();
		c2.pressAcceleratorButton();
		c2.setColor("Black");
		System.out.println("Color of c2: " + c2.getColor());
		c2.output();
	}
}