package basic;

import mylib.Validation;

public class Service {
	private final int MAX_PET = 10;
	private int id;
	private String name;
	private int price;
	private Pet[] petList;
	private int petCount;

	public Service() {
		this.id = 0;
		this.name = "";
		this.price = 0;
		this.petList = new Pet[MAX_PET];
		this.petCount = 0;
	}

	public Service(int id, String name, int price) {
		this.id = id;
		this.name = name;
		this.price = price;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
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
				String name = Validation.inputString("Enter the name", "");
				int price = (int) Validation.inputNumber("Enter the price", 1,100);
				setName(name);
				setPrice(price);
				valid = true;
			} catch (Exception e) {
				System.out.println("Error");
				valid = false;
			}
		} while (!valid);
	}

	public void output() {
		System.out.format("%10d%20s%10d", id, name, price);
		for (Pet pet: petList) {
			pet.output();
		}
	}

	public boolean addPet(Pet pet) {
		if (petCount < MAX_PET) {
			petList[petCount] = pet;
			petCount++;
			return true;
		}
		return false;
	}

	public int findPetIndex(int id) {
		for (int i = 0; i < petCount; i++) {
			if (petList[i].getId() == id) {
				return i;
			}
		}
		return -1;
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

	public boolean removePet(int id ) {
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