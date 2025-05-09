package servlet.manage;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import domain.Notices;
import service.NoticeService;

/**
 * Servlet implementation class EditNoticeByIdServlet
 */
@WebServlet("/EditNoticeByIdServlet")
public class EditNoticeByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditNoticeByIdServlet() {
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
		Notices notices=new Notices();
		//获取表单参数
		int n_id=Integer.parseInt(request.getParameter("notice_id"));
		String title=request.getParameter("notice_title");
		String details=request.getParameter("notice_context");
		//将当前时间设为添加公告的时间
		String n_time=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		notices.setN_id(n_id);
		notices.setTitle(title);
		notices.setDetails(details);
		notices.setN_time(n_time);
		
		noticeService.editNotice(notices);		
		request.getRequestDispatcher("ListNoticeServlet").forward(request, response);
	}

}
