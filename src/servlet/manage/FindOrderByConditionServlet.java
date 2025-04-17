package servlet.manage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Order;
import service.OrderService;



/**
 * Servlet implementation class FindOrderByConditionServlet
 */
@WebServlet("/FindOrderByConditionServlet")
public class FindOrderByConditionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindOrderByConditionServlet() {
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
		 //获取订单编号和收件人名称
		String id = request.getParameter("id");
		String receiverName = request.getParameter("receiverName");
        //创建Service层对象
		OrderService service = new OrderService();
		//调用Service层OrderService类的findOrderByManyCondition()方法查询数据
		List<Order> orders = service.findOrderByManyCondition(id, receiverName);
        //将查询结果添加到request作用域中
		request.setAttribute("orders", orders);
        //请求转发到list.jsp页面，并将request请求和response响应也转发到该页面中
		request.getRequestDispatcher("/admin/login/home.jsp?item="+"orders").forward(request,response);
	}

}
