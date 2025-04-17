package servlet.web;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Product;



/**
 * Servlet implementation class changeCartServlet
 */
@WebServlet("/changeCartServlet")
public class changeCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changeCartServlet() {
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
	@SuppressWarnings({ "unchecked" })
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 得到商品id
		String id = request.getParameter("id");
		// 得到要修改的数量
		int count = Integer.parseInt(request.getParameter("count"));
		// 从session中获取购物车.
		HttpSession session = request.getSession();
		Map<Product, Integer> cart = (Map<Product, Integer>) session.getAttribute("cart");
		Product p = new Product();
		p.setId(id);
		if (count != 0) {
			cart.put(p, count);
		} else {
			cart.remove(p);
		}
		response.sendRedirect(request.getContextPath() + "/client/Cart.jsp");
		return;
	}

}
