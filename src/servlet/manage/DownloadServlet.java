package servlet.manage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PseudoColumnUsage;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.sales;

/**
 * Servlet implementation class DownloadServlet
 */
@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//从request中获取搜索参数year和month的值；
		String year=request.getParameter("year");
		String month=request.getParameter("month");
		
		//调用模型层sales.java中的相关业务方法search，获取销售数量列表ps；
		List<sales> ps=new ArrayList<sales>();
		sales sales=new sales();
		ps=sales.search(year, month);
		
		//以文件形式下载，导出到扩展名为“.csv”的文件中
		String fileName=year+"年"+month+"月销售榜单.csv";
		response.setContentType(this.getServletContext().getMimeType(fileName));
		response.setHeader("Content-Disposition", "attachement;filename="+new String(fileName.getBytes("GBK"),"iso8859-1"));
		response.setCharacterEncoding("utf8");
		PrintWriter out=response.getWriter();
		out.println("商品名称，销售数量");
		for(int i=0;i<ps.size();i++) {
			sales arr=ps.get(i);
			out.println(arr.getName()+","+arr.getBuynum());
		}
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
