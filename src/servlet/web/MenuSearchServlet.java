package servlet.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import domain.Product;
import util.DbUtil;

/**
 * Servlet implementation class MenuSearchServlet
 */
@WebServlet("/MenuSearchServlet")
public class MenuSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//从request中获取搜索参数的值
		String searchfield =request.getParameter("textfield");
		
		//连接数据库进行模糊查询，获得结果集rs；
		List<Product> ps=new ArrayList<Product>();		
		//循环遍历结果集rs，设置产品属性，并将产品添加到ps产品列表中
		Connection conn=null;
		try {
			conn = DbUtil.getConnection();//建立与数据库的连接
		} catch (Exception e) {
			e.printStackTrace();
		}
		String sql="select * from products where name like '%"+searchfield+"%'";
		ResultSet rs=null;
		rs=DbUtil.executeQuery(sql);
		try {
			while(rs.next()){
				Product p=new Product();
				p.setId(rs.getString(1));
				p.setName(rs.getString(2));
				p.setPrice(rs.getDouble(3));
				p.setCategory(rs.getString(4));
				p.setPnum(rs.getInt(5));
				p.setImgurl(rs.getString(6));
				p.setDescription(rs.getString(7));
				
				ps.add(p);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		//将产品列表ps设置到request对象的ProductList参数中，并将请求转发给ProductList.jsp页面进行后续操作。
		request.setAttribute("p", ps);
		request.getRequestDispatcher("/client/productlist_search.jsp").forward(request, response);
		/*request.getSession().setAttribute("ProductList", ps);
		String qq=request.getContextPath();
		response.sendRedirect(qq+"/client/ProductList.jsp");*/
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
