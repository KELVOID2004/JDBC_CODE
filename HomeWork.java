import java.util.*;
import java.sql.*;

public class HomeWork {

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
        try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);) {
            boolean loop = true;
            Scanner sc = new Scanner(System.in);
            while (loop) {
                System.out.println("Enter either of the options: ");
                System.out.println("Press 1 to enter values to the data base : ");
                System.out.println("Press 2 to delete name from data base : ");
                System.out.println("Press 3 to search particular name in to the data base : ");
                System.out.println("Press 4 to update age in the data base : ");
                System.out.println("Press 5 to get all records from the database the data base : ");

                System.out.println("Enter your choise : ");
                int a = sc.nextInt();
                switch (a) {
                    case 1:
                        String ins = "INSERT into Registration(id,first,last,age) values (?,?,?,?)";
                        PreparedStatement pst = con.prepareStatement(ins);
                        System.out.println("Enter your Id : ");
                        int id = sc.nextInt();
                        pst.setInt(1, id);
                        System.out.println("Enter your First Name : ");
                        String firstName = sc.next();
                        pst.setString(2, firstName);
                        System.out.println("Enter your Last Name : ");
                        String lastName = sc.next();
                        pst.setString(3, lastName);
                        System.out.println("Enter your Age : ");
                        int age = sc.nextInt();
                        pst.setInt(4, age);

                        pst.executeUpdate();
                        pst.close();
                        break;
                    case 2:
                        String del = "delete from Registration where first = ?";
                        PreparedStatement pst1 = con.prepareStatement(del);
                        System.out.println("Enter the name to be deleted : ");
                        String name = sc.next();
                        pst1.setString(1, name);
                        pst1.executeUpdate();
                        pst1.close();
                        break;
                    case 3:
                        String sel = "SELECT first FROM Registration WHERE first = ?";
                        PreparedStatement pst2 = con.prepareStatement(sel);
                        System.out.println("Enter the name to be selected : ");
                        String name1 = sc.next();
                        pst2.setString(1, name1);
                        ResultSet resultSet = pst2.executeQuery();
                        String retrievedName = null;
                        if (resultSet.next()) {
                            retrievedName = resultSet.getString("first");
                        }
                        if (retrievedName != null) {
                            System.out.println("Retrieved name: " + retrievedName);
                        }
                        pst2.close();
                        break;
                    case 4:
                        String alt = "UPDATE registration SET age = ? WHERE first = ?";
                        PreparedStatement pst3 = con.prepareStatement(alt);
                        System.out.println("Enter the name of candidate to change the age ");
                        String name2 = sc.next();
                        System.out.println("Enter the age ");
                        int age2 = sc.nextInt();

                        pst3.setInt(1, age2);
                        pst3.setString(2, name2);
                        pst3.executeUpdate();
                        break;
                    case 5:
                        String all = "select * from registration";
                        Statement statement = con.createStatement();
                        ResultSet rs = statement.executeQuery(all);
                        while (rs.next()) {
                            int id_ = rs.getInt("id");
                            String first_ = rs.getString("first");
                            String last_ = rs.getString("last");
                            int age_ = rs.getInt("age");
                            System.out.println(
                                    "ID " + id_ + " FIRST NAME " + first_ + " LAST NAME " + last_ + " AGE " + age_);
                        }
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
                System.out.println("Do you Want to continue to work Type y to continue and n to stop");
                char c = sc.next().charAt(0);
                if (c == 'n') {
                    loop = false;
                    System.out.println("Thank You!!!");
                }
            }
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
