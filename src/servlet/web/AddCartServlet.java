package servlet.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Product;
import exception.FindProductByIdException;
import service.ProductService;

/**
 * Servlet implementation class AddCartServlet
 */
@WebServlet("/AddCartServlet")
public class AddCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCartServlet() {
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
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String p_id=request.getParameter("id");
		ProductService productService=new ProductService();
		try {
			Product product=productService.findProductByid(p_id);
			//获得session对象
			HttpSession session=request.getSession();
			Map<Product, Integer> cart = (Map<Product, Integer>)session.getAttribute("cart");
			//如果购物车为null,说明没有商品存储在购物车中，创建出购物车
			if (cart == null) {
				cart = new HashMap<Product, Integer>();
			}
			//购物车中添加商品
			Integer count = cart.put(product, 1);
			//如果商品数量不为空，则商品数量+1，否则添加新的商品信息
			if (count != null) {
				cart.put(product, count + 1);
			}			
			session.setAttribute("cart", cart);
			response.sendRedirect(request.getContextPath() + "/client/Cart.jsp");
		} catch (FindProductByIdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
