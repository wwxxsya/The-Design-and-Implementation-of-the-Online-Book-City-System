package dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import dao.ProductDao;
import domain.Product;
import util.DataSourceUtils;

public class ProductDaoImpl implements ProductDao {

	QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
	//查询数据库表products里的所有商品记录，并返回一个产品List
	@Override
	public List<Product> searchAll() throws SQLException {
		String sql="select * from products";
		return runner.query(sql, new BeanListHandler<Product>(Product.class));		
	}
	//添加
	@Override
	public void addProduct(Product product) throws SQLException {
		String sql="insert into products(id,name,price,category,pnum,imgurl,description) values(?,?,?,?,?,?,?)";
		runner.update(sql,product.getId(),product.getName(),product.getPrice(),product.getCategory(),
				product.getPnum(),product.getImgurl(),product.getDescription());
		
	}
	@Override
	public List<Product> findProductByManyCondition(String id, String category, String name, String minprice,
			String maxprice) throws SQLException {
		//sql拼接
		String sql="select * from products where 1=1";
		List<Object> list=new ArrayList<Object>();
		if (id != null && id.trim().length() > 0) {
			sql += " and id=?";
			list.add(id);
		}

		if (name != null && name.trim().length() > 0) {
			sql += " and name=?";
			list.add(name);
		}
		if (category != null && category.trim().length() > 0) {
			sql += " and category=?";
			list.add(category);
		}
		if (minprice != null && maxprice != null
				&& minprice.trim().length() > 0 && maxprice.trim().length() > 0) {
			sql += " and price between ? and ?";
			list.add(minprice);
			list.add(maxprice);
		}
		
		sql += " order by id";
		//toArray()方法返回一个Object数组,它就是Object不是其他类
		Object[] params = list.toArray();
		return runner.query(sql, new BeanListHandler<Product>(Product.class),params);
	}
	@Override
	public void editProduct(Product product) throws SQLException {
		String sql="update products set name=?,price=?,category=?,pnum=?,description=? where id=?";
		runner.update(sql,product.getName(),product.getPrice(),product.getCategory(),product.getPnum(),product.getDescription(),product.getId());
	}
	@Override
	public Product findProductById(String p_id) throws SQLException {
		String sql="select * from products where id = ?";
		return runner.query(sql, new BeanHandler<Product>(Product.class),p_id);
	}
	@Override
	public void deleteProduct(String p_id) throws SQLException {
		String sql="delete from products where id = ?";
		runner.update(sql,p_id);
		
	}
	@Override
	// 获取数据总条数
	public int findAllCount(String category) throws SQLException {
		String sql = "select count(*) from products";

		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

		if (!"全部商品".equals(category)) {
			sql += " where category=?";

			Long count = (Long) runner.query(sql, new ScalarHandler(), category);
			return count.intValue();
		} else {
			Long count = (Long) runner.query(sql, new ScalarHandler());

			return count.intValue();
		}
	}
	@Override
	// 获取当前页数据
		public List<Product> findByPage(int currentPage, int currentCount,
				String category) throws SQLException {
			// 要执行的sql语句
			String sql = null;
			// 参数
			Object[] obj = null;
			// 如果category不为null,代表是按分类查找
			if (!"全部商品".equals(category)) {
				sql = "select * from products  where category=? limit ?,?";
				obj = new Object[] { category, (currentPage - 1) * currentCount,
						currentCount, };
			} else {
				sql = "select * from products  limit ?,?";
				obj = new Object[] { (currentPage - 1) * currentCount,
						currentCount, };
			}
			QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
			return runner.query(sql, new BeanListHandler<Product>(Product.class),
					obj);
		}


}
