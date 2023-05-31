package Dao;

import java.sql.SQLException;

import Model.Account;

public interface AccountDao {
	Account findByUsername(String username) throws ClassNotFoundException, SQLException;
	
	void addAccount(String username, String password) throws ClassNotFoundException, SQLException ;
	
	int findIdByUsername(String username) throws ClassNotFoundException, SQLException ;
	
}
