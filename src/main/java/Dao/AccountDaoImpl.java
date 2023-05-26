package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.Account;

public class AccountDaoImpl implements AccountDao {
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/TouristGuide";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Project12321!";
    
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
    
    @Override
	public Account findByUsername(String username) throws ClassNotFoundException, SQLException  {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = this.getConnection();
		
	    String query = "SELECT * FROM Accounts WHERE username = ?";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, username);
		
		ResultSet resultSet = statement.executeQuery();
		
		if (resultSet.next()) {
			Account account = new Account(resultSet.getString(2), resultSet.getString(3));
			return account;
		}
		return null;
	}
    

    @Override
    public void addAccount(String username, String password) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = this.getConnection();
		
	    String query = "INSERT INTO Accounts (username, password) VALUES (?, ?)";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, username);
		statement.setString(2, password);
	    statement.executeUpdate();
    }
    
    
    @Override
    public int findIdByUsername(String username) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = this.getConnection();
		
	    String query = "SELECT account_id FROM Accounts WHERE username = ?";
	    PreparedStatement statement = connection.prepareStatement(query);
	    statement.setString(1, username);

	    ResultSet resultSet = statement.executeQuery();
	    if (resultSet.next()) {
	        return resultSet.getInt("account_id");
	    } 
        return -1; 
    }
    
    
}
