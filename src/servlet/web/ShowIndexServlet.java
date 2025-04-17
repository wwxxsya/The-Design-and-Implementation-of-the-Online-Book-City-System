package servlet.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Notices;
import service.NoticeService;

/**
 * Servlet implementation class ShowIndexServlet
 */
@WebServlet("/ShowIndexServlet")
public class ShowIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowIndexServlet() {
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
		//查询最近一条公告，传递到index.jsp页面进行展示
		NoticeService noticeService=new NoticeService();
		Notices notices=noticeService.getRecentNotice();
		request.setAttribute("notice", notices);
		request.getRequestDispatcher("/client/index.jsp").forward(request, response);
	}

}
