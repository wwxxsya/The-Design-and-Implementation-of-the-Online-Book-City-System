package dao;

import java.sql.SQLException;
import java.util.List;

import domain.Order;
import domain.OrderItem;

public interface OrderItemDao {
	// 根据订单id查找订单项.并将订单项中商品查找到
	public List<OrderItem>findOrderItemByOrder(final Order order)throws SQLException;
	// 根据订单id查找订单项，删除
	public  void delOrderItemByOrder(String id)throws SQLException;
	
}
