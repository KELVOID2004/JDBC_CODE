import java.sql.*;
public class create{
    
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
            Statement st = con.createStatement();
        )
        {
            String sql = "CREATE TABLE REGISTRATION " +
                   "(id INTEGER not NULL, " +
                   " first VARCHAR(255), " + 
                   " last VARCHAR(255), " + 
                   " age INTEGER, " + 
                   " PRIMARY KEY ( id ))"; 

         st.executeUpdate(sql);
         System.out.println("Created table in given database..."); 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}