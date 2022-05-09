package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {

    public Connection conn = null;

    public DAO(String url, String username, String password) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected!");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error" + e);
    }
}
    public DAO() {
        this("jdbc:sqlserver://localhost:1434;databaseName=BTL", "sa", "main");
    }
    public static void main(String[] args) {
        new DAO();
    }
}
