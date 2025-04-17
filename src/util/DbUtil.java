package util;
import java.sql.*;
public class DbUtil {
	//声明数据库连接信息
	private static final String URL="jdbc:mysql://localhost:3306/bookstore?"
	+"useSSL=true&serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=UTF-8";
	private static final String USER="root";
	private static final String PASSWORD="1019";
	//声明jdbc的相关对象
	protected static Statement s=null;
	protected static ResultSet rs=null;
	protected static Connection conn=null;
	//创建数据库连接
	public static synchronized Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(URL,USER,PASSWORD);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return conn;
	}
	//执行SQL语句，返回受影响条数
	public static int executeUpdate(String sql) {
		int result=0;
		try {
			s= getConnection().createStatement();
			result=s.executeUpdate(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	//执行select语句，返回二位结果集
	public static ResultSet executeQuery(String sql) {
		try {
			s=getConnection().createStatement();
			rs=s.executeQuery(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	//执行动态SQL语句
	public static PreparedStatement executePreparedStatement(String sql) {
		PreparedStatement ps=null;
		try {
			ps=getConnection().prepareStatement(sql);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ps;
	}
	//事务回滚
	public static void rollback() {
		try {
			getConnection().rollback();
		}catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	//关闭数据库连接对象
	public static void close() {
		try {
			if(rs!=null) rs.close();
			if(s!=null) s.close();
			if(conn!=null) conn.close();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
