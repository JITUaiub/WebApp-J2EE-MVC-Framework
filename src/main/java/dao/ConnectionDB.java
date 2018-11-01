package dao;

import java.sql.*;

public class ConnectionDB {
	private static String dbUrl = "jdbc:mysql://localhost:3306/ecommerce";
    private static String dbUsername = "root";
    private static String dbPassword = "";
    
	public ConnectionDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
    public Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
    }
	
}
