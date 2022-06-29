
public class StringDemo {
	//Different ways of creating strings
	void createString() {
		//Empty String
		String string = new String();
		
		//String initialized by an array of characters
		char chars[] = {'M', 'a', 't', 'i', 'l', 'd', 'a'};
		string = new String(chars);
		System.out.println(string + " is initialized using an array of characters.");
		
		//Subrange of character array
		String substring = new String(chars, 0, 3);
		System.out.println(substring + " is a subrange of a character array.");
		
		//Using another String object
		String stringClone = new String(string);
		System.out.println(stringClone + " is initialized using another string object.");
		
		//Initialize string using byte array
		byte bytechars[] = {70, 101, 115, 116, 97};
		String stringFromByte = new String(bytechars);
		System.out.println(stringFromByte + " is initialized using an array of bytes.");
		
		//Subrange of character array
		String substringBytes = new String(bytechars, 0, 4);
		System.out.println(substringBytes + " is a subrange of a byte array.");
		
		//Using a string literal
		String stringLiteral = new String("Epiphany");
		System.out.println(stringLiteral + " is a string literal.");
	}
	
	int getLength(String string) {
		return string.length();
	}
	
	void concatenateStrings() {
		
		//Using + Operator
		System.out.println("This is a "
				+ "concatenated string.");
		
		//Concatenation with other data types
		int types = 8;
		System.out.println("Java has " + types + " primitive data types.");
		
	}
	
	void extractCharacters() {
		//Extract single character
		String string = "String for extraction";
		System.out.println("The character at index 6 of " + string + " is " + string.charAt(6));
		
		//Extract a range of characters
		int start =  11, end = 18;
		char buffer[] = new char[end-start];
		string.getChars(start, end, buffer, 0);
		System.out.println("The extracted characters are: " + new String(buffer));
	}
	
	void compareStrings() {
		String string1 = "Java";
		String string2 = "java";
		String string3 = "Java";
		String string4 = "Python";
		String string5 = new String(string1);
		
		System.out.println(string1 + " equals " + string2 + "-->" + string1.equals(string2));
		System.out.println(string1 + " equals " + string3 + "-->" + string1.equals(string3));
		System.out.println(string1 + " equals " + string4 + "-->" + string1.equals(string4));
		System.out.println(string1 + " equals(ignore case) " + string2 + "-->" + string1.equalsIgnoreCase(string2));
		System.out.println(string1 + " equals " + string5 + "-->" + string1.equals(string5));
		System.out.println(string1 + " == " + string5 + "-->" + (string1 == string5));
	}
	
	public static void main(String args[]) {
		StringDemo instance = new StringDemo();
		instance.createString();
		System.out.println("The length of the string \"Java\" is " + instance.getLength("Java"));
		instance.extractCharacters();
		System.out.println();
		instance.compareStrings();
	}
}
