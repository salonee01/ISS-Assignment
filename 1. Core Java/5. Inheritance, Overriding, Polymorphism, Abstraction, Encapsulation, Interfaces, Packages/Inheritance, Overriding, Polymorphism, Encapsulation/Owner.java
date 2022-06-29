
public class Owner {
	String firstName, lastName;
	int age, contactNumber;
	char gender;
	
	Owner(String firstName, String lastName, int age, int contactNumber, char gender) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.contactNumber = contactNumber;
		this.gender = gender;
	}

	/**
	 * @return the firstName
	 */
	protected String getFirstName() {
		return firstName;
	}

	/**
	 * @return the lastName
	 */
	protected String getLastName() {
		return lastName;
	}

	/**
	 * @return the age
	 */
	protected int getAge() {
		return age;
	}

	/**
	 * @return the contactNumber
	 */
	protected int getContactNumber() {
		return contactNumber;
	}

	/**
	 * @return the gender
	 */
	protected char getGender() {
		return gender;
	}
	
	
	
}
