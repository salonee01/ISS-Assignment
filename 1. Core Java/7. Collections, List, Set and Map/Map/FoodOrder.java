import java.util.HashMap;
import java.util.Set;

public class FoodOrder {

	public static void main(String[] args) {
		HashMap<String, Double> dishes = new HashMap<String, Double>();
        
        //Add items
        dishes.put("Loaded Nachos", 350.00);
        dishes.put("Baked Garlic and Cheese Bread", 150.00);
        dishes.put("Tomato and Chilli Pasta", 450.00);
        dishes.put("Paneer Tikka Pizza", 550.00);
        System.out.println("The food order is: " + dishes);
        
        //Getting value for the given key        
        System.out.println("\nPrice of Loaded Nachos: " + dishes.get("Loaded Nachos"));
        System.out.println("\nAre there no orders? " + dishes.isEmpty());
        
        dishes.remove("Paneer Tikka Pizza");
        
        System.out.println("\n" + dishes);
        System.out.print("\nSize of the food order: " + dishes.size());
        
        Set<String> dishNames = dishes.keySet();
		for (String dish : dishNames) {

			System.out.print(dish + " ");

		}
		
		// Iterating through HashMap Items

		System.out.println("\nSearching food order keys or names \n");
		if (dishes.containsKey("Tomato and Chilli Pasta")) {

			System.out.println("The food order contains key Tomato and Chilli Pasta");

		} else {

			System.out.println("The food order does not contains key Tomato and Chilli Pasta");

		}

		if (dishes.containsKey("Margherita")) {

			System.out.println("The food order contains key Margherita");

		} else {

			System.out.println("The food order does not contain key Margherita");

		}
		

		//Searching Items Price using containsValue
		if (dishes.containsValue(450.00)) {

			System.out.println("The food order contains value 450.00");

		} else {

			System.out.println("The food order does not contain value 450.00");

		}
	}

}
