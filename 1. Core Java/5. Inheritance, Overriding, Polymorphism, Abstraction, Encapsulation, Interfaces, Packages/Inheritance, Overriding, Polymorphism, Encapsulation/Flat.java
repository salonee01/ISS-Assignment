
public class Flat extends Home{

	int floor, apartment;
	
	Flat(int rooms, int floor, int apartment) {
		super(rooms);
		this.floor = floor;
		this.apartment = apartment;
	}

	protected int getFloor() {
		return floor;
	}

	protected void setFloor(int floor) {
		this.floor = floor;
	}

	protected int getApartment() {
		return apartment;
	}

	protected void setApartment(int apartment) {
		this.apartment = apartment;
	}
	
	// Method overriding
	void printHouseDetails() {
//		super.printHouseDetails();
		System.out.println("The flat is on the " + floor + " floor.\nApartment No. " + apartment);
	}
	
	public static void main(String args[]) {
		Home homeInstance = new Flat(3, 7, 1701);
		Home home = new Home(5);
		
		//Polymorphism
		home.printHouseDetails();
		homeInstance.printHouseDetails();
		
		//Encapsulation
		homeInstance.setLocation("Mumbai");
		System.out.println("It is located at " + homeInstance.getLocation());
		
	}
	
	
	
}
