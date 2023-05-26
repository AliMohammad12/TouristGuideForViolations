package Service;

import java.sql.SQLException;

import Dao.UserDao;
import Model.User;


public class UserService {
	private UserDao userDao;

	public UserService(UserDao userDao) {
	    this.userDao = userDao;
	}
	
	public boolean checkPhoneNumberExistence(String phoneNumber) throws ClassNotFoundException, SQLException {
		return userDao.checkPhoneNumberExistence(phoneNumber) == true;
	}

	public void addUser(User user, int accountId) throws ClassNotFoundException, SQLException {
		userDao.addUser(user, accountId);
	}

}
