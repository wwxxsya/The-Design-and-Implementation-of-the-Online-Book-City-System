package servlet.manage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDao;
import dao.OrderItemDao;
import dao.Factory.DaoFactory;
import domain.Order;
import domain.OrderItem;

/**
 * Servlet implementation class DelOrderByIdServlet
 */
@WebServlet("/DelOrderByIdServlet")
public class DelOrderByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DelOrderByIdServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		// 从request中获取订单id的值
		String id = request.getParameter("id");
		// 从DaoFactory中获取一个OrderItemDao实现类的实例对象；
		OrderItemDao orderItemDao = DaoFactory.getOrderItemDAOInstance();
		// 从DaoFactory中获取一个OrderDao实现类的实例对象；
		OrderDao orderDao = DaoFactory.getOrderDAOInstance();

		List<Order> orders = null;
		try {
			//删除
			orderDao.delOrderByIdServlet(id);
			orderItemDao.delOrderItemByOrder(id);
			//调用OrderDao的findAllOrder()方法;			
			orders=orderDao.findAllOrder();			
		} catch (Exception e) {
			// TODO: handle exception
		}
		// 将查询到的订单信息order添加到request作用域;
		// 将请求转发到home.jsp页面，并传递item参数，
		request.setAttribute("orders", orders);
		request.getRequestDispatcher("/admin/login/home.jsp?item="+"orders").forward(request, response);

	}

}
