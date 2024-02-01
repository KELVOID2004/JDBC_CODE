import java.sql.*;
public class insert{
    
    static final String DB_URL = "jdbc:mysql://localhost:3306/STUDENT";
    static final String DB_DRV = "com.mysql.jdbc.Driver";
    static final String DB_PASSWD = "";
    static final String DB_USER = "root";
    
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
            System.out.println("Inserting records into the table...");          
            String sql = "INSERT INTO Registration VALUES (100, 'Zara', 'Ali', 18)";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO Registration VALUES (101, 'Mahnaz', 'Fatma', 25)";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO Registration VALUES (102, 'Zaid', 'Khan', 30)";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO Registration VALUES(103, 'Sumit', 'Mittal', 28)";
            stmt.executeUpdate(sql);
            System.out.println("Inserted records into the table...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}