import java.util.Iterator;
import java.util.LinkedList;

public class WebBrowser {

	public static void main(String[] args) {
	       /* Linked List Declaration */
	       LinkedList<String> browserHistory = new LinkedList<String>();

	       // Add elements
	       browserHistory.add("www.google.com");
	       browserHistory.add("www.instagram.com");
	       browserHistory.add("www.geeksforgeeks.org");
	       browserHistory.add("www.nytimes.com");
	       browserHistory.add("www.jetpunk.com");

	       /*Display Linked List Content*/
	       System.out.println("Linked List Content: " + browserHistory);

	       /*Add First and Last Element*/
	       browserHistory.addFirst("www.sih.com");
	       browserHistory.addLast("www.zomato.com");
	       System.out.println("LinkedList Content after addition: " + browserHistory);

	       // Get and set values
	       System.out.println("First element: " + browserHistory.get(0));
	       browserHistory.set(0, "www.netflix.com");
	       System.out.println("First element after update by set method: " + browserHistory.get(0));

	       /*Remove first and last element*/
	       browserHistory.removeFirst();
	       browserHistory.removeLast();
	       System.out.println("LinkedList after deletion of first and last element: " +browserHistory);

	       /* Add to a Position and remove from a position*/
	       browserHistory.add(0, "www.wikipedia.com");
	       browserHistory.remove(2);
	       
	       System.out.print("Final Content: "); 
	       
	       //Iterating LinkedList
	       Iterator<String> iterator=browserHistory.iterator();
	       while(iterator.hasNext()){
	         System.out.print(iterator.next() + " ");
	       }
	 }

}
