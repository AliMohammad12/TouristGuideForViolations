package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.Role;
import Model.User;

public class UserDaoImpl implements UserDao {
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/?user=root";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Project12321!";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

	@Override
	public boolean checkPhoneNumberExistence(String phoneNumber) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = this.getConnection();
		
		String query = "select * from User where phone_number = " + phoneNumber;
		Statement statement = (Statement) connection.createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		if (resultSet.next()) {
			return true;
		}
		return false;
	}
    
    
	@Override
	public void addUser(User user, int accountId)  throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = this.getConnection();
		
		String query = "INSERT INTO Users VALUES (?, ?, ?, ?, ?)";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, user.getFirstName());
		statement.setString(2, user.getLastName());
		statement.setString(3, user.getPhoneNumber());
		statement.setInt(4, accountId);
		statement.setString(5, Role.USER.toString());
	    statement.executeUpdate();
	}

}
