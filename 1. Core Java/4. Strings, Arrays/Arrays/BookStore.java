import java.util.Random;

public class BookStore {
	
	
	public static void printBookPrices(int[] bookPrices) {
		
		// Traversing an array
		for(int bookPrice:bookPrices)
			System.out.print(bookPrice + ", ");
	}
	
	
	//Return an array
	public static int[] updateBookPrices(int[] bookPrices) {
		for(int i = 0; i<bookPrices.length; i++)
			bookPrices[i] += 50;
		return bookPrices;
	}
	
	
	public static void main(String[] args) {
		//Array Declaration
		int[] bookPrices = new int[5];
		int total = 0;
		
		//Array Initialization
		for (int i=0;i<5;i++) {
			Random rand = new Random();
			bookPrices[i] = rand.nextInt(450);
		}
		
		//Passing array as a parameter
		System.out.print("The prices of books are: ");
		printBookPrices(bookPrices);
		
		for (int i=0;i<5;i++) {
			total += bookPrices[i];
		}
		System.out.println("\nThe total cost of " + bookPrices.length + " books is " + total);
		
		int maxPrice = bookPrices[0];
		for (int price : bookPrices) {
			if(price>maxPrice)
				maxPrice = price;
		}
		System.out.println("The maximum price of a book is " + maxPrice);
		
		System.out.print("The updated price of books is: ");
		printBookPrices(updateBookPrices(bookPrices));
		
		//Cloning an array
		int[] cloneBookPrices = bookPrices.clone();
		System.out.print("\nThe prices of books are(cloned array): ");
		printBookPrices(cloneBookPrices);
		
		//Multi-dimensional Arrays
		int bookOrder1[][]={{208, 154, 318},{165, 219, 281}};  
		int bookOrder2[][]={{368, 88, 459},{331, 439, 461}};  
		   
		int totalOrder[][]=new int[2][3];  
		
		System.out.print("\nThe total order is: ");  
		//Addition of multi-dimensional arrays 
		
		for(int i=0;i<2;i++){  
			for(int j=0;j<3;j++){  
				totalOrder[i][j] = bookOrder1[i][j] + bookOrder2[i][j];  
				System.out.print(totalOrder[i][j] + " "); 
			}
		} 
		
	}

}
