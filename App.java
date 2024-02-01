import java.sql.*;
public class App{
    
    static final String DB_URL = "jdbc:mysql://localhost:3306/  ";
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
            Statement st = con.createStatement();
        )
        {
            String sql = "CREATE DATABASE STUDENT";
            st.executeUpdate(sql);
            System.out.println("Database created successfully...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}