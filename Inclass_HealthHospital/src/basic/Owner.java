package basic;

import mylib.Validation;

public class Owner {
	private final int MAX_PET = 10;
	private int id;
	private String name;
	private String address;
	private Pet[] petList;
	private int petCount;

	public Owner() {
		this.id = 0;
		this.name = "";
		this.address = "";
		this.petList = new Pet[MAX_PET];
		this.petCount = 0;
	}

	public Owner(int id, String name, String address) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.petList = new Pet[MAX_PET];
		this.petCount = 0;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Pet[] getPetList() {
		return petList;
	}

	public void setPetList(Pet[] petList) {
		this.petList = petList;
	}

	public int getPetCount() {
		return petCount;
	}

	public void setPetCount(int petCount) {
		this.petCount = petCount;
	}

	public void input() {
		boolean valid = true;
		do {
			try {
				String name = Validation.inputString("Enter Owner's name", "\\w+");
				String address = Validation.inputString("Enter Owner's address", "\\w+");
				setName(name);
				setAddress(address);
				valid = true;
			} catch (Exception e) {
				System.out.println("Invalud Input");
				valid = false;
			}
		} while (!valid);
	}

	public void output() {
		System.out.println("Customer ID: " + id);
		System.out.println("Customer name: " + name);
		System.out.println("Address: " + address);
		for (Pet pet : petList) {
			pet.output();
		}
	}

	public boolean addPet(Pet pet) {
		if (petCount < MAX_PET) {
			petList[petCount] = pet;
			petCount--;
			return true;
		}
		return false;
	}

	public boolean updatePet(int id) {
		int uP = findPetIndex(id);
		if (uP == -1) {
			System.out.println("Cannot find pet with the ID: "+ id);
			return false;
		}
		petList[uP].input();
		return true;
	}

	public int findPetIndex(int id) {
		for (int i = 0; i < petCount; i++) {
			if (petList[i].getId() == id) {
				return i;
			}
		}
		return -1;
	}

	public boolean removePet(int id) {
		int rP = findPetIndex(id);
		if (rP == -1 ) {
			System.out.println("Cannot find pet with ID: "+ id);
			return false;
		}
		for (int i = rP; i < petCount; i++) {
			petList[i] = petList[i+1];
		}
		petList[petCount-1] = null;
		petCount--;
		return true;
	}

	public void sortPetById() {
		for (int i = 0; i < petCount; i++) {
			for (int j = i+1; j <petCount; j++) {
				if(petList[i].getId() > petList[j].getId()) {
					Pet temp = petList[i];
					petList[i] = petList[j];
					petList[j] = temp;
				}
			}
		}
	}
	public void displayAllPets() {
		for (Pet pet : petList) {
			pet.output();
		}
	}
}