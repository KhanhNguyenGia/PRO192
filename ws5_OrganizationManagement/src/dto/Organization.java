package dto;

public abstract class Organization {
	private int size;
	public Organization() {
		this.size= 0;
	}
	public Organization(int size) {
		this.size = size;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public abstract void communicateByTool();
	public String toString() {
		return "The organization's size is " + size;
	}
}