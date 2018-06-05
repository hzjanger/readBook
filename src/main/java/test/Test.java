package test;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args){
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/BookRead";
        String user = "root";
        String password = "123456";
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
        } catch(ClassNotFoundException e) {
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
