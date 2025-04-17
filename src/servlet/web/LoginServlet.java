package servlet.web;

import java.io.IOException;

import javax.security.auth.login.LoginException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取登录页面输入的用户名与密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// 调用service完成登录操作
		UserService userService=new UserService();
		User user=new User();
		try {
			user=userService.login(username, password);
			// 登录成功，将用户存储到session中
			request.getSession().setAttribute("user", user);
			request.getSession().setAttribute("username", username);
			request.getRequestDispatcher("/client/loginsuccess.jsp").forward(request, response);
		} catch (LoginException e) {			
			e.printStackTrace();
			request.setAttribute("register_message", e.getMessage());
			request.getRequestDispatcher("ShowIndexServlet").forward(request, response);
			return;
		}
		
	}

}
