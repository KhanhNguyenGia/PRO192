package basic;

import mylib.Validation;

public class Manager extends Staff {
	private final int MAX_STAFF_COUNT = 10;
	private int bonus;
	private Staff[] staffList;
	private int staffCount;

	public Manager() {
		super();
		this.bonus = 0;
		this.staffList = new Staff[MAX_STAFF_COUNT];
		this.staffCount = 0;
	}

	public Manager(int bonus, int id, String name, String gender, int basic) {
		super(id, name, gender, basic);
		this.bonus = bonus;
		this.staffList = new Staff[MAX_STAFF_COUNT];
		this.staffCount = 0;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	public Staff[] getStaffList() {
		return staffList;
	}

	public void setStaffList(Staff[] staffList) {
		this.staffList = staffList;
	}

	public int getStaffCount() {
		return staffCount;
	}

	public void setStaffCount(int staffCount) {
		this.staffCount = staffCount;
	}

	public boolean addStaff(Staff staff) {
		if (staffCount < MAX_STAFF_COUNT) {
			staffList[staffCount] = staff;
			staffCount++;
			return true;
		}
		return false;
	}

	public Staff findStaff(int id) {
		for (Staff staff : staffList) {
			if (staff.getId() == id) {
				return staff;
			}
		}
		return null;
	}

	public int findStaffIndex(int id) {
		for (int i = 0; i < staffCount; i++) {
			if (staffList[i].getId() == id) {
				return i;
			}
		}
		return -1;
	}

	public boolean removeStaff(int id) {
		int rS = findStaffIndex(id);
		if (rS == -1) {
			System.out.println("Cannot find staff with ID: " + id);
			return false;
		}
		for (int i = rS; i < staffCount - 1; i++) {
			staffList[i] = staffList[i + 1];
		}
		staffList[staffCount - 1] = null;
		staffCount--;
		return true;
	}

	public void displayAllStaffs() {
		if (staffCount == 0) {
			System.out.println("Staff list is empty");
			return;
		}
		for (Staff staff : staffList) {
			staff.outputStaff();
		}
	}

	@Override
	public void inputStaff() {
		boolean valid =true;
		do {
			super.inputStaff();
			try {
				bonus = (int) Validation.inputNumber("Enter bonus", 1, 100);
				valid = true;
			} catch (Exception e) {
				System.out.println("Error");
				valid = false;
			}
		} while (!valid);
	}

	@Override
	public void outputStaff() {
		super.outputStaff();
		System.out.println("-" + bonus + "-" + staffCount);
		System.out.println("Managing:");
		displayAllStaffs();
	}

	@Override
	public String toString() {
		return super.toString() + "-" + bonus + "-" + staffCount;
	}
}