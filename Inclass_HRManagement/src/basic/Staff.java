package basic;

import mylib.Validation;

public class Staff {
	private final int MAX_TASKS = 10;
	private int id;
	private String name;
	private String gender;
	private int basic;
	private Task[] toDoList;
	private int taskCount;

	public Staff() {
		this.id = 0;
		this.name = "";
		this.gender = "";
		this.basic = 0;
		this.toDoList = new Task[MAX_TASKS];
		this.taskCount = 0;
	}

	public Staff(int id, String name, String gender, int basic) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.basic = basic;
		this.toDoList = new Task[MAX_TASKS];
		this.taskCount = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getBasic() {
		return basic;
	}

	public void setBasic(int basic) {
		this.basic = basic;
	}

	public Task[] getToDoList() {
		return toDoList;
	}

	public void setToDoList(Task[] toDoList) {
		this.toDoList = toDoList;
	}

	public int getTaskCount() {
		return taskCount;
	}

	public void setTaskCount(int taskCount) {
		this.taskCount = taskCount;
	}

	public boolean addTask(Task task) {
		if (taskCount < MAX_TASKS) {
			toDoList[taskCount] = task;
			taskCount++;
			return task.addStaff(this);
		}
		return false;
	}

	public int findTaskIndex(int id) {
		for (int i = 0; i < taskCount; i++) {
			if (toDoList[i].getId() == id) {
				return i;
			}
		}
		return -1;
	}

	public boolean removeTask(int id) {
		int rT = findTaskIndex(id);
		if (rT == -1) {
			System.out.println("Cannot find task with ID: " + id);
			return false;
		}
		// Remove the current staff from the removed task
		if (!toDoList[rT].removeStaff(this.id)) {
			return false;
		}
		for (int i = rT; i < taskCount - 1; i++) {
			toDoList[i] = toDoList[i + 1];
		}
		toDoList[taskCount - 1] = null;
		taskCount--;
		return true;
	}

	public void displayAllTasks() {
		if (taskCount == 0) {
			System.out.println("Task list is empty");
			return;
		}
		for (Task task : toDoList) {
			task.output();
		}
	}

	public void inputStaff() {
		boolean valid = true;
		do {
			try {
				id = (int) Validation.inputNumber("Input ID (1-100): ", 1, 100);
				name = Validation.inputString("Input name: ", "^[a-zA-Z]+$");
				gender = Validation.inputString("Input gender ([F/M]): ", "^[FM]$");
				basic = (int) Validation.inputNumber("Input basic salary (1-100): ", 1, 100);
				valid = true;
			} catch (Exception e) {
				System.out.println("Error");
				valid = false;
			}
		} while (!valid);
	}

	public void outputStaff() {
		System.out.print(id + "-" + name + "-" + gender + "-" + basic);
	}

	@Override
	public String toString() {
		return id + "-" + name + "-" + gender + "-" + basic;
	}
}