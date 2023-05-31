package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import Dao.AccountDaoImpl;
import Model.Account;
import Service.AccountService;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    
	private AccountService accountService;
	
    public void init() {
    	AccountDaoImpl accountDaoImpl = new AccountDaoImpl();
    	accountService = new AccountService(accountDaoImpl);
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Account account = new Account();
		try {
			account = accountService.findByUsername(username);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		if (account == null) {
			response.sendRedirect("/JSP/login_page.jsp"); 
		} else if (account.getPassword() == password) {
			//response.sendRedirect("JSP/welcome.jsp");
		} else {
			response.sendRedirect("/JSP/login_page.jsp"); 
		}
	}

}
