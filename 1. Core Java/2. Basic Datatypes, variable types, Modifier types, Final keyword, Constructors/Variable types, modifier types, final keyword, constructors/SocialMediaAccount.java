
public class SocialMediaAccount {
	
	// Instance variables using different modifier types
	public String firstName, lastName;
	private int age;
	String description; //default modifier
	protected int numberOfPosts;
	
	//Constant variable (static and final)
	static final String socialMediaPlatform = "Social Bee";

	String getFirstName() {
		return firstName;
	}

	void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	String getLastName() {
		return lastName;
	}

	void setLastName(String lastName) {
		this.lastName = lastName;
	}

	int getAge() {
		return age;
	}

	void setAge(int age) {
		this.age = age;
	}

	String getDescription() {
		return description;
	}

	void setDescription(String description) {
		this.description = description;
	}

	int getNumberOfPosts() {
		return numberOfPosts;
	}

	void setNumberOfPosts(int numberOfPosts) {
		this.numberOfPosts = numberOfPosts;
	}

	static String getSocialMediaPlatform() {
		return socialMediaPlatform;
	}
	
	//Default Constructor
	SocialMediaAccount(){
		System.out.println("Using default constructor");
		this.firstName = "NA";
		this.lastName = "NA";
		this.age = 0;
	}

	//Parameterized Constructor
	SocialMediaAccount(String firstName, String lastName, int age){
		System.out.println("Using parameterized contructor");
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	void setDetails(String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	void printDetails() {
		System.out.println("This account belongs to " + firstName + " " + lastName);
	}

}
