package servlet.manage;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Product;
import service.ProductService;

/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductServlet() {
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
		
		String name=request.getParameter("name");
		double price=Double.parseDouble(request.getParameter("price"));
		int pnum=Integer.parseInt(request.getParameter("pnum"));
		String category=request.getParameter("category");
		String imgurl=request.getParameter("imgurl");
		String description=request.getParameter("description");	
		
		products.setId(UUID.randomUUID().toString());
		products.setName(name);
		products.setPrice(price);
		products.setPnum(pnum);
		products.setCategory(category);
		products.setImgurl(imgurl);
		products.setDescription(description);
		
		productService.addProduct(products);
		request.getRequestDispatcher("ListProductServlet").forward(request, response);
		
	}

}
