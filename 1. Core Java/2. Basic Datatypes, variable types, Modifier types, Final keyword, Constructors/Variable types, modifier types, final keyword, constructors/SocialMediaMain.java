
public class SocialMediaMain {

	public static void main(String args[]) {
		SocialMediaAccount socialAccount1 = new SocialMediaAccount();
		socialAccount1.setDetails("Tina", "Lesley", 24);
		socialAccount1.printDetails();
		SocialMediaAccount socialAccount2 = new SocialMediaAccount("James", "Colins", 43);
		socialAccount2.printDetails();
		
		// Accessing private variables through methods
		socialAccount1.setNumberOfPosts(18);
		socialAccount2.setDescription("Working at NBC");
		
		System.out.println(socialAccount1.firstName + " " + socialAccount1.lastName
				+ " has posted " + socialAccount1.getNumberOfPosts() + " times.");
		System.out.println(socialAccount2.firstName + " " + socialAccount2.lastName + " is " + socialAccount2.getAge() + 
			".");	
		
	}
}
