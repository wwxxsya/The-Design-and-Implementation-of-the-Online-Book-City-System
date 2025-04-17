package service;

import java.sql.SQLException;
import java.util.List;

import dao.OrderDao;
import dao.impl.OrderDaoImpl;
import domain.Order;

public class OrderService {
	private OrderDao orderDao=new OrderDaoImpl();
	
	public List<Order>findOrderByManyCondition(String id,String receiverName){
		List<Order>orders=null;
		
			try {
				orders=orderDao.findOrderByManyCondition(id, receiverName);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return orders;
	}
}
