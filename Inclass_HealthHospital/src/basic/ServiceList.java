package basic;

public class ServiceList {
	private final int MAX_SERVICE = 10;
	private Service[] serviceList;
	private int serviceCount;

	public ServiceList() {
		this.serviceList = new Service[MAX_SERVICE];
		this.serviceCount = 0;
	}

	public Service[] getServiceList() {
		return serviceList;
	}

	public void setServiceList(Service[] serviceList) {
		this.serviceList = serviceList;
	}

	public int getServiceCount() {
		return serviceCount;
	}

	public void setServiceCount(int serviceCount) {
		this.serviceCount = serviceCount;
	}

	public boolean addService(Service service) {
		if (serviceCount < MAX_SERVICE) {
			serviceList[serviceCount] = service;
			serviceCount++;
			return true;
		}
		return false;
	}

	public int findServiceIndex(int id) {
		for (int i = 0; i < serviceCount; i++) {
			if (serviceList[i].getId() == id) {
				return i;
			}
		}
		return -1;
	}

	public boolean deleteService(int id) {
		int rS = findServiceIndex(id);
		if (rS == -1) {
			System.out.println("Cannot find service with the ID: " + id);
			return false;
		}
		for (int i = 0; i < serviceCount - 1; i++) {
			serviceList[i] = serviceList[i + 1];
		}
		serviceList[serviceCount - 1] = null;
		serviceCount--;
		return true;
	}

	public boolean updateService(int id) {
		int uS = findServiceIndex(id);
		if (uS == -1) {
			System.out.println("Cannot find service with the ID: "+ id);
			return false;
		}
		serviceList[uS].input();
		return true;
	}

	public void sortById() {
		for (int i = 0; i < serviceCount; i++) {
			for (int j = i+1; j < serviceCount; j++) {
				if (serviceList[i].getId() > serviceList[j].getId()) {
					Service temp = serviceList[i];
					serviceList[i] = serviceList[j];
					serviceList[j] = temp;
				}
			}
		}
	}

	public void displayAllService() {
		for (Service service : serviceList) {
			service.output();
		}
	}
}