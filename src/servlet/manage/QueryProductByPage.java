package servlet.manage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ProductService;
import util.pageHelp;

/**
 * Servlet implementation class QueryProductByPage
 */
@WebServlet("/QueryProductByPage")
public class QueryProductByPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QueryProductByPage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1.定义当前页码，默认为1
		int currentPage = 1;
		String _currentPage = request.getParameter("currentPage");
		if (_currentPage != null) {
			currentPage = Integer.parseInt(_currentPage);
		}
		// 2.定义每页显示条数,默认为4
		int currentCount = 4;
		String _currentCount = request.getParameter("currentCount");
		if (_currentCount != null) {
			currentCount = Integer.parseInt(_currentCount);
		}
		// 3.获取查找的分类
		String category = "全部商品";
		String _category = request.getParameter("category");
		if (_category != null) {
			category = _category;
		}
		// 4.调用service，完成获取当前页分页Bean数据.
		ProductService service = new ProductService();
		pageHelp ProductList = service.findProductByPage(currentPage, currentCount, category);
		// 将数据存储到request范围，跳转到product_list.jsp页面展示
		request.setAttribute("ProductList", ProductList);
		request.getRequestDispatcher("/client/ProductList.jsp").forward(request, response);
		return;
	}

}
