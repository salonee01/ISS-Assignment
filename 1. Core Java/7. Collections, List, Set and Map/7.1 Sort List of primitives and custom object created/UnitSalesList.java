import java.util.ArrayList;
import java.util.Collections;

public class UnitSalesList {

	public static void main(String[] args) {
		
		int totalSales = 0;

		//Create ArrayList of type Integer
		ArrayList<Integer> salesList = new ArrayList<Integer>();
		
		//Add elements to the ArrayList
		salesList.add(324);
		salesList.add(211);
		salesList.add(113);
		salesList.add(615);
		salesList.add(432);
		
		//Size of ArrayList
		System.out.println("Initial size of ArrayList is: " + salesList.size());
		
		//Display elements
		System.out.print("The sales numbers are: ");
		for (int sales:salesList) {
			System.out.print(sales + " ");
		}
		
		//Add element at a particular position
		salesList.add(3, 234);
		
		//Remove an element
		salesList.remove(1);
		
		//Display elements
		System.out.print("\nArray List after insertion and deletion: ");
		for (int sales:salesList) {
			System.out.print(sales + " ");
		}
		
		//Calculating total sales
		for (int sales:salesList) {
			totalSales += sales;
		}
		System.out.print("\nThe total sales are " + totalSales);
		
		Collections.sort(salesList);
		System.out.print("\nArray List after sorting: ");
		for (int sales:salesList) {
			System.out.print(sales + " ");
		}

	}

}
