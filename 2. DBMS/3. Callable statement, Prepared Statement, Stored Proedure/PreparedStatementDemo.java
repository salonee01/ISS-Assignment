import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementDemo {
   static final String DB_URL = "jdbc:mysql://localhost:3306/northwind?allowPublicKeyRetrieval=true&useSSL=false";
   static final String USER = "root";
   static final String PASS = "salONEe1*";
   static final String QUERY = "select * from products where UnitPrice > ? AND Discontinued = ? ORDER BY UnitPrice ASC";

   public static void main(String[] args) {
      // Open a connection
      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
    		  PreparedStatement pst = conn.prepareStatement(QUERY);
      ) {		               
 		pst.setInt(1, 20);
 		pst.setInt(2, 0);
 		
 		ResultSet rs = pst.executeQuery();
         while (rs.next()) {
             System.out.println("ID = " + rs.getInt(1) + ", Product Name = " + rs.getString(2) + 
                   ", Unit Price = " + rs.getInt(6));
          }

      } catch (SQLException e) {
         e.printStackTrace();
      } 
   }
}