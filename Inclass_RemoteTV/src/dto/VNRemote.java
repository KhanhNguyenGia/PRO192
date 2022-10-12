package dto;

public interface VNRemote {
	final int MAXofButtons = 20;
	int price = 10;
	public static void setTimer(int number) {
		System.out.println("Shut down after " + number + " seconds");
	}
	public abstract void onDevice();
	public abstract void offDevice();
	default void setLock() {
		System.out.println("Set lock in the default method");
	}
}