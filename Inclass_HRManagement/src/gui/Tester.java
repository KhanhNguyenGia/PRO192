package gui;

import basic.Manager;
import basic.Staff;
import basic.Task;
import basic.TaskList;
import mylib.Validation;

public class Tester {
	public static void main(String[] args) {
		int c = 0;
		Manager manager = null;
		TaskList taskList = new TaskList();
		do {
			System.out.println("1. Create a manager");
			System.out.println("2. Add one staff to manager");
			System.out.println("3. Add one task to task list");
			System.out.println("4. Display task list");
			System.out.println("5. Assign task to staff");
			System.out.println("6. Display staff list of manager");
			System.out.println("0. Exit");
			try {
				c = (int) Validation.inputNumber("Enter the selection", 0, 6);
				switch (c) {
					case 1 -> {
						manager = new Manager();
						manager.inputStaff();
					}
					case 2 -> {
						if (manager == null) {
							System.out.println("Manager does not exist");
							break;
						}
						Staff staff = new Staff();
						staff.inputStaff();
						if (manager.addStaff(staff)) {
							System.out.println("Staff added successfully");
							break;
						}
						System.out.println("Staff failed to add");
					}
					case 3 -> {
						Task task = new Task();
						task.input();
						if (taskList.addTask(task)) {
							System.out.println("Task added successfully");
							break;
						}
						System.out.println("Task failed to add");
					}
					case 4 -> {
						taskList.displayAllTasks();
					}
					case 5 -> {
						if (manager == null) {
							System.out.println("Manager does not exist");
							break;
						}
						manager.displayAllStaffs();
						taskList.displayAllTasks();
						int staffID = (int) Validation.inputNumber("Enter the staff ID: ", 0, 100);
						int taskID = (int) Validation.inputNumber("Enter the task ID: ", 0, 100);
						Task t = taskList.findTask(taskID);
						Staff s = manager.findStaff(staffID);
						if (t != null && s != null) {
							if (s.addTask(t)) {
								System.out.println("Task assigned successfully");
								break;
							}
							System.out.println("Task failed to assign");
						}
					}
					case 6 -> {
						if (manager == null) {
							System.out.println("Manager does not exist");
							break;
						}
						manager.displayAllStaffs();
					}
					case 0 -> {
						System.out.println("Exiting");
					}
				}
			} catch (Exception e) {
				System.out.println("Invalid selection");
			}
		} while (c != 0);
	}
}