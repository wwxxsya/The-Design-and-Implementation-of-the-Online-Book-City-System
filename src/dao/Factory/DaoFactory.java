package dao.Factory;

import dao.NoticeDao;
import dao.OrderDao;
import dao.OrderItemDao;
import dao.ProductDao;
import dao.UserDao;
import dao.impl.NoticeDaoImpl;
import dao.impl.OrderDaoImpl;
import dao.impl.OrderItemDaoImpl;
import dao.impl.ProductDaoImpl;
import dao.impl.UserDaoImpl;

public class DaoFactory {
	public DaoFactory() {
		
	}
	//返回获得OrderDao实现类的实例。
	public static OrderDao getOrderDAOInstance() {
		return new OrderDaoImpl();
	}
	//返回获得OrderItemDao实现类的实例。
	public static OrderItemDao getOrderItemDAOInstance() {
		return new OrderItemDaoImpl();
	}
	//返回获得NoticeDao实现类的实例
	public static NoticeDao getNoticeDAOInstance() {
		return new NoticeDaoImpl();
	}
	//返回获得UserDao实现类的实例
	public static UserDao getUserDAOInstance() {
		return new UserDaoImpl();
	}
	//返回获得OrderDao实现类的实例
	public static ProductDao getProductDAOInstance() {
		return new ProductDaoImpl();
	}
}
