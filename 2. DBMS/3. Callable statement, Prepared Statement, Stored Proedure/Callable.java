import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Callable {
	static final String DB_URL = "jdbc:mysql://localhost:3306/northwind?allowPublicKeyRetrieval=true&useSSL=false";
	   static final String USER = "root";
	   static final String PASS = "salONEe1*";
	   static final String QUERY = "{call SelectAllCustomers}";

	   public static void main(String[] args) {
	      // Open a connection
	      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	         CallableStatement stmt = conn.prepareCall(QUERY);
	      ) {		      
	         System.out.println("Executing stored procedure..." );
	         ResultSet rs = stmt.executeQuery();
	         while (rs.next()) {
	             System.out.println("ID = " + rs.getString(1) + ", Company Name = " + rs.getString(2) + 
	                   ", Customer Name = " + rs.getString(3));
	          }

	      } catch (SQLException e) {
	         e.printStackTrace();
	      } 
	   }
}
