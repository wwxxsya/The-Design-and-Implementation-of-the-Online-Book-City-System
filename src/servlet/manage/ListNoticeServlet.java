package servlet.manage;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class FindNoticeServlet
 */
@WebServlet("/ListNoticeServlet")
public class ListNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListNoticeServlet() {
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
		List<Notices>notices=noticeService.getAllNotices();
		//将信息添加到request作用域的变量中
		request.setAttribute("notices", notices);
		// 将请求转发到home.jsp页面并传递参数item
		request.getRequestDispatcher("/admin/login/home.jsp?item="+"notices").forward(request,response);
	}

}
