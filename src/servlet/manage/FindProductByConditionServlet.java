package servlet.manage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Product;
import service.ProductService;

/**
 * Servlet implementation class FindProductByConditionServlet
 */
@WebServlet("/FindProductByConditionServlet")
public class FindProductByConditionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindProductByConditionServlet() {
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
		//获取list页面传来的参数
		String id=request.getParameter("id");
		String category=request.getParameter("category");
		String name=request.getParameter("name");
		String minprice=request.getParameter("minprice");
		String maxprice=request.getParameter("maxprice");
		//创建ProductService对象
		ProductService productService=new ProductService();
		//调用service层用于条件查询的方法
		List<Product> products=productService.findProductByCondition(id, category, name, minprice, maxprice);
		
		request.setAttribute("products",products);
		request.getRequestDispatcher("/admin/login/home.jsp?item="+"product_list").forward(request, response);
		
	}

}
