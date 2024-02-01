import java.sql.*;
public class update{
    
    static final String DB_URL = "jdbc:mysql://localhost:3306/STUDENT";
    static final String DB_DRV = "com.mysql.jdbc.Driver";
    static final String DB_PASSWD = "";
    static final String DB_USER = "root";
    static final String QUERY = "SELECT id, first, last, age FROM Registration";
    
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }
        try(Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            Statement stmt = con.createStatement();
        )
        {
            String sql = "UPDATE Registration " +
            "SET age = 30 WHERE id in (100, 101)";
         stmt.executeUpdate(sql);
         ResultSet rs = stmt.executeQuery(QUERY);
         while(rs.next()){
            //Display values
            System.out.print("ID: " + rs.getInt("id"));
            System.out.print(", Age: " + rs.getInt("age"));
            System.out.print(", First: " + rs.getString("first"));
            System.out.println(", Last: " + rs.getString("last"));
         }
         rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}