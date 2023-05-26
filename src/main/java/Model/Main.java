package Model;

import java.sql.SQLException;

import Dao.AccountDaoImpl;
import Dao.UserDaoImpl;
import Service.AccountService;
import Service.UserService;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		AccountService accountService;
		UserService userService;
		
    	AccountDaoImpl accountDaoImpl = new AccountDaoImpl();
    	UserDaoImpl userDaoImpl = new UserDaoImpl();
    	
    	accountService = new AccountService(accountDaoImpl);
    	userService = new UserService(userDaoImpl);	
    	
    	
    	//accountService.addAccount("Khaled", "12321");
    	int id = accountService.findIdByUsername("Khaled");
    	System.out.println(id);
    	
    	Account account = accountService.findByUsername("Ali");
    	System.out.println(account.getUserName() + " " + account.getPassword()); 
    	
    	
    	
	}

}
