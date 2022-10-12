package basic;

import mylib.Validation;

public class Task {

	private final int MAX_STAFF = 10;
	private int id;
	private String title;
	private int beginDate;
	private int endDate;
	private int totalHours;
	private Staff[] assignedStaffs;
	private int staffCount;

	public Task() {
		this.id = 0;
		this.title = "";
		this.beginDate = 0;
		this.endDate = 0;
		this.totalHours = 0;
		this.assignedStaffs = new Staff[MAX_STAFF];
		this.staffCount = 0;
	}

	public Task(int id, String title, int beginDate, int endDate, int totalHours) {
		this.id = id;
		this.title = title;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.totalHours = totalHours;
		this.assignedStaffs = new Staff[MAX_STAFF];
		this.staffCount = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(int beginDate) {
		this.beginDate = beginDate;
	}

	public int getEndDate() {
		return endDate;
	}

	public void setEndDate(int endDate) {
		this.endDate = endDate;
	}

	public int getTotalHours() {
		return totalHours;
	}

	public void setTotalHours(int totalHours) {
		this.totalHours = totalHours;
	}

	public Staff[] getAssignedStaffs() {
		return assignedStaffs;
	}

	public void setAssignedStaffs(Staff[] assignedStaffs) {
		this.assignedStaffs = assignedStaffs;
	}

	public int getStaffCount() {
		return staffCount;
	}

	public void setStaffCount(int staffCount) {
		this.staffCount = staffCount;
	}

	public boolean addStaff(Staff staff) {
		if (staffCount < MAX_STAFF) {
			assignedStaffs[staffCount] = staff;
			staffCount++;
			return true;
		}
		return false;
	}

	public int findStaffIndex(int id) {
		for (int i = 0; i < staffCount; i++) {
			if (assignedStaffs[i].getId() == id) {
				return i;
			}
		}
		return -1;
	}

	public boolean removeStaff(int id) {
		int rS = findStaffIndex(id);
		if (rS==-1) {
			System.out.println("Cannot find staff with the ID: " + id);
			return false;
		}
		for (int i = rS; i < staffCount -1 ; i++) {
			assignedStaffs[i] = assignedStaffs[i+1];
		}
		assignedStaffs[staffCount-1] = null;
		staffCount--;
		return true;
	}

	public void displayAllStaffs() {
		if (staffCount == 0) {
			System.out.println("Staff list is empty");
			return;
		}
		for (Staff staff: assignedStaffs) {
			staff.outputStaff();
		}
	}

	public void input() {
		boolean valid = true;
		do {
			try {
				title = Validation.inputString("Enter the title of task: ", "");
				beginDate = (int) Validation.inputNumber("Enter the begin date of task: ", 0, 100);
				endDate = (int) Validation.inputNumber("Enter the end date of task: ", 0, 100);
				totalHours = (int) Validation.inputNumber("Enter the total hours of task: ", 0, 24);
				valid = true;
			} catch (Exception e) {
				System.out.println("Invalid input");
				valid = false;
			}
		} while (!valid);
	}

	public void output() {
		System.out.println(id + ": " + title + ", " + beginDate + ", " + endDate + ", " + totalHours);
	}
}