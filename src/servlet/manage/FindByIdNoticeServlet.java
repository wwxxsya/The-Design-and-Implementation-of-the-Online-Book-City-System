package servlet.manage;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NoticeDao;
import dao.Factory.DaoFactory;
import domain.Notices;
import service.NoticeService;

/**
 * Servlet implementation class FindByIdNoticeServlet
 */
@WebServlet("/FindByIdNoticeServlet")
public class FindByIdNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindByIdNoticeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeService noticeService=new NoticeService();
		//获取公告id
		String n_id=request.getParameter("id");
		Notices notices=noticeService.findNoticeById(n_id);
		//将信息添加到request作用域的变量中
		request.setAttribute("n",notices);
		// 将请求转发到home.jsp页面并传递参数item
		request.getRequestDispatcher("/admin/login/home.jsp?item="+"notice_edit").forward(request, response);
		
		
	}

}
