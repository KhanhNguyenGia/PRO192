package basic;

import mylib.Validation;

public class TaskList {
	private final int MAX_COUNT = 100;
	private Task[] list;
	private int count;


	public TaskList() {
		this.list = new Task[MAX_COUNT];
		this.count = 0;
	}

	public TaskList(Task[] list, int count) {
		this.list = list;
		this.count = count;
	}

	public Task[] getList() {
		return list;
	}

	public void setList(Task[] list) {
		this.list = list;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public boolean addTask(Task T) {
		if (count < MAX_COUNT) {
			list[count] = T;
			count++;
			return true;
		}
		return false;
	}

	public Task findTask(int id) {
		for (Task T : list) {
			if (T.getId() == id) {
				return T;
			}
		}
		return null;
	}

	public int findTaskIndex(int id) {
		for (int i = 0; i < count; i++) {
			if (list[i].getId() == id) {
				return i;
			}
		}
		return -1;
	}

	public boolean updateTask(int id) {
		Task uT = findTask(id);
		if (uT == null) {
			return false;
		}
		uT.input();
		return true;
	}

	public boolean removeTask(int id) {
		int index = findTaskIndex(id);
		if (index == -1) {
			return false;
		}
		for (int i = index; i < count - 1; i++) {
			list[i] = list[i + 1];
		}
		list[count - 1] = null;
		count--;
		return true;
	}

	public void sortById() {
		for (int i = 0; i < count - 1; i++) {
			for (int j = i + 1; j < count; j++) {
				if (list[i].getId() > list[j].getId()) {
					Task temp = list[i];
					list[i] = list[j];
					list[j] = temp;
				}
			}
		}
	}

	public void displayAllTasks() {
		if (count == 0) {
			System.out.println("Task list is empty");
			return;
		}
		for (Task T : list) {
			T.output();
		}
	}
}