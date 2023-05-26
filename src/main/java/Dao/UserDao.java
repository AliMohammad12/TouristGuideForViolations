package Dao;

import java.sql.SQLException;

import Model.User;

public interface UserDao {
	boolean checkPhoneNumberExistence(String phoneNumber) throws ClassNotFoundException, SQLException;

	void addUser(User user, int accountId) throws ClassNotFoundException, SQLException;
}
