package domain;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DbUtil;

public class sales {
	private String name;
	private int buynum;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBuynum() {
		return buynum;
	}
	public void setBuynum(int buynum) {
		this.buynum = buynum;
	}
	
	public List<sales>search(String year,String month){
		List<sales> ps=new ArrayList<sales>();
		Connection conn=null;
		try {
			conn=DbUtil.getConnection();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		String sql="SELECT products.name,SUM(orderitem.buynum) totalsalnum "
				+ "FROM orders,products,orderItem "
				+ "WHERE orders.id=orderItem.order_id "
				+ "AND products.id=orderItem.product_id AND orders.paystate=1 "
				+ "AND year(ordertime)= "+year+" AND month(ordertime)="+month+" "
				+"GROUP BY products.name ORDER BY totalsalnum DESC";
		
		ResultSet rs=null;
		rs=DbUtil.executeQuery(sql);
		try {
			while(rs.next()) {
				sales s=new sales();
				s.setName(rs.getString(1));
				s.setBuynum(rs.getInt(2));				
				ps.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ps;
	}
}
