package servlet.manage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Product;
import service.ProductService;

/**
 * Servlet implementation class EditProductByIdServlet
 */
@WebServlet("/EditProductByIdServlet")
public class EditProductByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProductByIdServlet() {
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
		Product products=new Product();
		String p_id=request.getParameter("products_id");
		String products_name=request.getParameter("products_name");
		double products_price=Double.parseDouble(request.getParameter("products_price"));
		int products_pnum=Integer.parseInt(request.getParameter("products_pnum"));
		String products_category=request.getParameter("products_category");
		String products_description=request.getParameter("products_description");
		
		products.setId(p_id);
		products.setName(products_name);
		products.setPrice(products_price);
		products.setPnum(products_pnum);
		products.setCategory(products_category);
		products.setDescription(products_description);
		
		productService.editProduct(products);
		request.getRequestDispatcher("ListProductServlet").forward(request, response);
	}

}
