package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import dao.OrderItemDao;
import domain.Order;
import domain.OrderItem;
import domain.Product;
import domain.User;
import util.DataSourceUtils;

public class OrderItemDaoImpl implements OrderItemDao {

	@Override
	public List<OrderItem> findOrderItemByOrder(Order order) throws SQLException {
		// TODO Auto-generated method stub
		//1.创建sql
		String sql = "select orderitem.*,products.* from orderitem,products where products.id=orderitem.product_id and order_id=?";
		//2.构造一个指定数据源ds的QueryRunner对象
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());		
        //3.返回QueryRunner对象query()方法的查询结果
		return runner.query(sql, new ResultSetHandler<List<OrderItem>>() {					
			public List<OrderItem> handle(ResultSet rs) throws SQLException {
				//创建订单集合
				List<OrderItem> OrderItems = new ArrayList<OrderItem>();
                //循环遍历订单和用户信息
				while (rs.next()) {
					//将从数据库中查询到的订单项属性添加到订单项对象中
					OrderItem orderItem = new OrderItem();
					orderItem.setOrder(order);
					orderItem.setBuynum(rs.getInt("orderitem.buynum"));
					
                    //将从数据库中查询到的商品属性添加到用户对象中
					Product product=new Product();
					product.setId(rs.getString("products.id"));
					product.setName(rs.getString("products.name"));
					product.setDescription(rs.getString("products.description"));
					product.setCategory(rs.getString("products.category"));
					product.setPnum(rs.getInt("products.pnum"));
					product.setPrice(rs.getDouble("products.price"));
					
					//将商品对象添加到订单项对象中
					orderItem.setP(product);
					//将订单项对象添加到订单项链表集合中
					OrderItems.add(orderItem);
				}
				return OrderItems;//返回订单项链表集合
			}
		},order.getId());
	}

	@Override
	public void delOrderItemByOrder(String id) throws SQLException {
		//1.创建sql
				String sql = "delete from orderitem where order_id=?";
				//2.构造一个指定数据源ds的QueryRunner对象
				QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());		
		        //3.返回QueryRunner对象query()方法的查询结果
				runner.update(sql, id);
	}

}
