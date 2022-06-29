import java.sql.*;

public class EmployeeInfoManager {
   static final String DB_URL = "jdbc:mysql://localhost/upaisthit";
   static final String USER = "root";
   static final String PASS = "root";
   static final String QUERY = "SELECT * from employee_info";

   public static void main(String[] args) {
      // Open a connection
      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(QUERY);) {
         // Extract data from result set
         while (rs.next()) {
        	 System.out.print(rs.getString("employee_id") + ", ");
        	 System.out.print(rs.getString("employee_designation") + ", ");
        	 System.out.print(rs.getString("employee_department") + ", ");
        	 System.out.print(rs.getString("employee_status") + "\n");
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } 
   }
}