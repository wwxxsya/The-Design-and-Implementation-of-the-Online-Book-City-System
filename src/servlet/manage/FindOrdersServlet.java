package servlet.manage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDao;
import dao.Factory.DaoFactory;
import dao.impl.OrderDaoImpl;
import domain.Order;

/**
 * Servlet implementation class FindOrdersServlet
 */
@WebServlet("/FindOrdersServlet")
public class FindOrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindOrdersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		//从DaoFactory中获取一个OrderDao实现类的实例；
		OrderDao orderdao=DaoFactory.getOrderDAOInstance();
		List<Order> orders=null;
		try {					
			//调用OrderDao的findAllOrder()方法;			
			orders=orderdao.findAllOrder();	
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		//将查询到的订单链表信息orders添加到request作用域的"orders"变量中
		request.setAttribute("orders", orders);
		// 将请求转发到orderList.jsp页面并传递参数item="+"orders"
		request.getRequestDispatcher("/admin/login/home.jsp?item="+"orders").forward(request,response);
		
		
	}

}
