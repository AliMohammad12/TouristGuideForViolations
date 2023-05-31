package Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import Dao.AccountDao;
import Dao.AccountDaoImpl;
import Dao.UserDao;
import Dao.UserDaoImpl;
import Model.Account;
import Model.Role;
import Model.User;
import Service.AccountService;
import Service.UserService;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
       
	private AccountService accountService;
	private UserService userService;
	
    public void init() {
        AccountDao accountDao = new AccountDaoImpl();
        UserDao userDao = new UserDaoImpl();

        accountService = new AccountService(accountDao);
        userService = new UserService(userDao);
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String phoneNumber = request.getParameter("phone");
		
		System.out.println(username + " " + password + " " + firstName + " " + lastName + " " + phoneNumber);
		int accountId;
		try {
			accountId = accountService.findIdByUsername(username);
		} catch (ClassNotFoundException | SQLException e) {
			accountId = -1;
		}		
		System.out.println(" " + accountId);
		
		if (accountId != -1) {
			// found in database
			String warningMessage = "account with username specified already exists, please try another!";
			request.setAttribute("warningMessage", warningMessage);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("JSP/register_page.jsp");
			requestDispatcher.forward(request, response);
		} else {
			// not found in database
			// let's check user table for the phone number..
			boolean exists;
			try {
				exists = userService.checkPhoneNumberExistence(phoneNumber);
			} catch (ClassNotFoundException | SQLException e) {
				exists = false;
			}
			
			if (exists) {
				String warningMessage = "Phone number specified already exists, please try another!";
				request.setAttribute("warningMessage", warningMessage);
				
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("JSP/register_page.jsp");
				requestDispatcher.forward(request, response);
			} else {	
				
				System.out.println("We are good");
				try {
					accountService.addAccount(username, password);
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
				
				try {
					accountId = accountService.findIdByUsername(username);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				User user = new User(firstName, lastName, phoneNumber, username, password, Role.USER);
				try {
					userService.addUser(user, accountId);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				String warningMessage = "Congratulations! Your account has been created successfully!";
				request.setAttribute("warningMessage", warningMessage);
				
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("JSP/login_page.jsp");
				requestDispatcher.forward(request, response);				
			}

		}
		
	}
}
