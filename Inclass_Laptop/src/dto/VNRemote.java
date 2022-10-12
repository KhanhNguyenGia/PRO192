package dto;

public interface VNRemote {
	final int MAXofButtons = 20;
	int price = 10;
	// Static methods belong to class instead of an instance.
	// Invoke by calling VNRemote.setTimer();
	public static void setTimer(int number) {
		System.out.println("Shut down after " + number + " seconds");
	}
	public abstract void onDevice();
	public abstract void offDevice();
	// Default methods are available by default without implementations.
	default void setLock() {
		System.out.println("Set lock in the default method");
	}
}