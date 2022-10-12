package basic;

import mylib.Validation;

public class Pet {
	private final int MAX_SERVICE = 10;
	private int id;
	private String name;
	private String gender;
	private String birthday;
	private Service[] usedService;
	private int serviceCount;

	public Pet() {
		this.id = 0;
		this.name = "";
		this.gender = "";
		this.birthday = "";
		this.usedService = new Service[MAX_SERVICE];
		this.serviceCount = 0;
	}

	public Pet(int id, String name, String gender, String birthday) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.usedService = new Service[MAX_SERVICE];
		this.serviceCount = 0;
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

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public Service[] getUsedService() {
		return usedService;
	}

	public void setUsedService(Service[] usedService) {
		this.usedService = usedService;
	}

	public int getServiceCount() {
		return serviceCount;
	}

	public void setServiceCount(int serviceCount) {
		this.serviceCount = serviceCount;
	}

	public void input() {
		boolean valid = true;
		do {
			try {
				String name = Validation.inputString("Enter Pet's name", "\\w+");
				String gender = Validation.inputString("Enter Pet's gender", "\\w+");
				String birthday = Validation.inputString("Enter Pet's birthday", "\\w+");
				setName(name);
				setGender(gender);
				setBirthday(birthday);
				valid = true;
			} catch (Exception e) {
				System.out.println("Invalid input");
				valid = false;
			}
		} while (!valid);
	}

	public void output() {
		System.out.format("%10d%20s%10s%20s", id, name, gender, birthday);
		for (Service service : usedService) {
			service.output();
		}
	}

	public boolean addService(Service service) {
		if (serviceCount < MAX_SERVICE) {
			usedService[serviceCount] = service;
			serviceCount++;
			if (!service.addPet(this)) {
				serviceCount--;
				usedService[serviceCount] = null;
				return false;
			}
			return true;
		}
		return false;
	}

	public int findServiceIndex(int id) {
		for (int i = 0; i < serviceCount; i++) {
			if (usedService[i].getId() == id) {
				return i;
			}
		}
		return -1;
	}

	public boolean updateService(int id) {
		int uS = findServiceIndex(id);
		if (uS == -1) {
			System.out.println("Cannot find the service with ID: " + id);
			return false;
		}
		usedService[uS].input();
		return true;
	}

	public boolean removeService(int id) {
		int rS = findServiceIndex(id);
		if (rS == -1) {
			System.out.println("Cannot find the service with ID: " + id);
			return false;
		}
		if (!usedService[rS].removePet(this.id)) {
			return false;
		}
		for (int i = rS; i < serviceCount; i++) {
			usedService[i] = usedService[i + 1];
		}
		return true;
	}

	public void sortServiceById() {
		for (int i = 0; i < serviceCount; i++) {
			for (int j = i+1; j <serviceCount; j++) {
				if(usedService[i].getId() > usedService[j].getId()) {
					Service temp = usedService[i];
					usedService[i] = usedService[j];
					usedService[j] = temp;
				}
			}
		}
	}
	public void displayAllServices() {
		for (Service service : usedService) {
			service.output();
		}
	}
}