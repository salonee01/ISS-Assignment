import java.util.Scanner;

public class Calculator {
	
	
	public static void main(String args[]) {
		
		int operand1, operand2, choice=0;
		double result = 0;
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Calculator");
			while (choice != 5) {
				System.out.println("1.Addition\n2.Subtraction\n3.Multiplication"
						+ "\n4.Division\n5.Exit\nEnter your choice:");
				choice = scanner.nextInt();
				if (choice == 5)
					continue;					
				System.out.println("Enter the first operand: ");
				operand1 = scanner.nextInt();
				System.out.println("Enter the second operand: ");
				operand2 = scanner.nextInt();
				
				switch(choice) {
				case 1:
					result = operand1 + operand2;
					break;
				case 2:
					result = operand1 - operand2;
					break;
				case 3:
					result = operand1 * operand2;
					break;
				case 4:
					try {
						result = operand1 / operand2;
					}
					catch(ArithmeticException e){
						System.out.println("Invalid division by 0!");
						continue;
					}
					break;
				default:
					System.out.println("Choose an appropriate option.");
				
				}
				System.out.println("The result is " + result);

				
				
			}
		}
		
	}
	
}
