
public class BasicDataTypes {
	public static void main(String args[])

	{
		System.out.println("\nChar data type");
		char marks, grade;	
		marks = '8';	
		grade = 'B';	
		System.out.println("Marks: "+marks);	
		System.out.println("Grade: "+grade);
		
		System.out.println("\nByte data type");
		byte myByte1, myByte2;
		myByte1 = 127; 
		myByte2 = -48;
		System.out.println("Byte 1: "+myByte1);
		System.out.println("Byte 2: "+myByte2);
		myByte1++; // Looping back within the range
		System.out.println("Incremented Value of myByte1: "+myByte1);
		
		System.out.println("\nShort data type");
		short myShort = 6000;
		System.out.println("myShort: " + myShort);
		
		System.out.println("\nInt data type");
		int myNum1, myNum2, result;
		myNum1 = -7000;
		myNum2 = 90000;
		result = myNum1 + myNum2;
		System.out.println("Number 1: "+myNum1);
		System.out.println("Number 2: "+myNum2);
		System.out.println("Number 1+ Number 2: "+result);
		
		System.out.println("\nLong data type");
		long myLong1, myLong2, resultLong;
		myLong1 = 100000000L;
		myLong2 = 200L;
		resultLong = myLong1 * myLong2;
		System.out.println("Number 1:"+myLong1);
		System.out.println("Number 2: " +myLong2); 
		System.out.println("Number 1 Number 2: "+resultLong);
		
		System.out.println("\nFloat data type");
		float myFloat1, myFloat2, resultsFloat;
		myFloat1=1000.666f; 
		myFloat2=110.77f;
		resultsFloat=myFloat1-myFloat2;
		System.out.println("Number1: "+myFloat1);
		System.out.println("Number 2: "+myFloat2);
		System.out.println("Number 1-Number2: "+resultsFloat);
		
		System.out.println("\nDouble data type");
		double myDouble1, myDouble2, resultDouble;
		myDouble1 = 48976.8987;
		myDouble2 = 29513.7812d;
		resultDouble = myDouble1+ myDouble2; 
		System.out.println("Number 1: " +myDouble1);
		System.out.println("Number 2: "+myDouble2);
		System.out.println("Number 1+ Number 2:" + resultDouble);
		
		System.out.println("\nBoolean data type");
		boolean myBool = true;
		if(myBool = true)
		System.out.println("Boolean data type is being used."); 
		System.out.println(myBool);

	}
}
