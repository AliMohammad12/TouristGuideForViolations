package Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

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
    	AccountDaoImpl accountDaoImpl = new AccountDaoImpl();
    	UserDaoImpl userDaoImpl = new UserDaoImpl();
    	
    	accountService = new AccountService(accountDaoImpl);
    	userService = new UserService(userDaoImpl);
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String phoneNumber = request.getParameter("phoneNumber");
		
		try {
			Account account = accountService.findByUsername(username);
			// found in database
			String warningMessage = "account with username specified already exists, please try another!";
			request.setAttribute("warningMessage", warningMessage);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("JSP/register_page.jsp");
			requestDispatcher.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// not found in database
			// let's check user table for the phone number..
			
			try {
				if (userService.checkPhoneNumberExistence(phoneNumber) == true) {
					String warningMessage = "Phone number specified already exists, please try another!";
					request.setAttribute("warningMessage", warningMessage);
					
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("JSP/register_page.jsp");
					requestDispatcher.forward(request, response);
				} else {	
					accountService.addAccount(username, password);
					int accountId = accountService.findIdByUsername(username);
					
					User user = new User(firstName, lastName, phoneNumber, username, password, Role.USER);
					userService.addUser(user, accountId);
					response.sendRedirect("JSP/login_page.jsp"); 
				}
			} catch (ClassNotFoundException | SQLException | ServletException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
	}

}
