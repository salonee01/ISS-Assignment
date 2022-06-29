import java.util.Arrays;
import java.util.List;

public class Print {
	
	void print(String s) {
		if (s == null) {
			throw new NullPointerException("Exception: s is null!");
		} 
		System.out.println("Inside print method: " + s);
	}

	public static void main(String[] args) { 
		
		Print print = new Print(); 
		List<String> list = Arrays.asList("first step", null, "second step");
	

		for (String s: list) {

			try {
	
				print.print(s);
	
			}
	
			catch (NullPointerException e) {
	
				System.out.println(e.getMessage()); 
				System.out.println("Exception handled. The program will continue");
	
			} finally {
	
				System.out.println("Inside finally block"); 
			}
			System.out.println("The program is running...");
			System.out.println("");
		
		}
	}
}
		
