package Service;

import java.sql.SQLException;

import Dao.AccountDao;
import Dao.AccountDaoImpl;
import Model.Account;

public class AccountService {
	private AccountDao accountDao;
	
	public AccountService (AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	public Account findByUsername(String username) throws ClassNotFoundException, SQLException {
		return accountDao.findByUsername(username);
	}
	
	public void addAccount(String username, String password) throws ClassNotFoundException, SQLException {
		accountDao.addAccount(username, password);
	}
	
	public int findIdByUsername(String username) throws ClassNotFoundException, SQLException {
		return accountDao.findIdByUsername(username);
	}
	
}
