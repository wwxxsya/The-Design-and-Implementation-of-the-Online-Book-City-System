package dao;

import java.sql.SQLException;
import java.util.List;

import domain.Order;


public interface OrderDao {
	 // 查找所有订单
	public List<Order>findAllOrder()throws SQLException;
	// 根据id查找订单信息
	public Order findOrderById(String id)throws SQLException;
	//删除
	public void delOrderByIdServlet(String n_id)throws SQLException;
	//根据条件查找
	public List<Order> findOrderByManyCondition(String id,String receiverName)throws SQLException;
}
