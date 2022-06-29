import java.io.File;  
import java.io.FileWriter;
import java.io.IOException;  
import java.util.Scanner;

public class FileReadWrite {
  public static void main(String[] args) {
    try {
      File myObj = new File("filename.txt");
      //Create file if it does not exist
      if (myObj.createNewFile()) {
        System.out.println("File created: " + myObj.getName());
      } else {
        System.out.println("File already exists.");        
      }
      
      //Write to an existing file
      FileWriter myWriter = new FileWriter("filename.txt");
      myWriter.write("Writing to a file in Java");
      myWriter.close();
      System.out.println("Successfully wrote to the file.");
      
      //Read from existing file
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        System.out.println(data);
      }
      myReader.close();
    
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}