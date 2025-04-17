package dao;

import java.sql.SQLException;
import java.util.List;

import domain.Product;

public interface ProductDao {
	//查询数据库表products里的所有商品记录，并返回一个产品List
	public List<Product> searchAll()throws SQLException;
	//添加
	public void addProduct(Product product) throws SQLException;
	//根据条件查找
	public  List<Product> findProductByManyCondition(String id, String category,
			String name, String minprice, String maxprice)throws SQLException;
	//编辑
	public void editProduct(Product product)throws SQLException;
	//根据id查找
	public Product findProductById(String p_id)throws SQLException;
	//根据id删除
	public void deleteProduct(String p_id)throws SQLException;
	// 获取数据总条数
	public int findAllCount(String category) throws SQLException;
	// 获取当前页数据
	public List<Product> findByPage(int currentPage, int currentCount,String category) throws SQLException ;
}
