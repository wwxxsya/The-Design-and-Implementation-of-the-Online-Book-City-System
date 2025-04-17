package servlet.manage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Product;
import exception.FindProductByIdException;
import service.ProductService;

/**
 * Servlet implementation class FindProductByIdServlet
 */
@WebServlet("/FindProductByIdServlet")
public class FindProductByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindProductByIdServlet() {
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
		ProductService productService=new ProductService();
		String p_id=request.getParameter("id");
		Product products=new Product();
		try {
			products = productService.findProductByid(p_id);
			request.setAttribute("products", products);
		} catch (FindProductByIdException e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/admin/login/home.jsp?item="+"product_edit").forward(request, response);
	}

}
