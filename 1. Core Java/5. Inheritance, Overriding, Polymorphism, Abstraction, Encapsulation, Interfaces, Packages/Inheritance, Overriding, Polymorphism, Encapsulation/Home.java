
public class Home {
	private int rooms;
	private String location;
	boolean isFurnished;
	Owner owner;
	
	
	Home(int rooms) {
		this.rooms = rooms;
	}
	
	void setOwnerDetails(String firstName, String lastName, int age, int contactNumber, char gender) {
		owner.firstName = firstName;
		owner.lastName = lastName;
		owner.age = age;
		owner.contactNumber = contactNumber;
		owner.gender = gender;
	}
	
	void printHouseDetails() {
		System.out.println("The house has " + rooms + " rooms.");
	}
	
	void printOwnerDetails() {
		System.out.println("It is owned by " + owner.firstName + " " + owner.lastName);
	}
	
	void setLocation(String location) {
		this.location = location;
	}

	String getLocation() {
		return location;
	}

	
}
