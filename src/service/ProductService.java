package service;

import java.sql.SQLException;
import java.util.List;

import exception.FindProductByIdException;
import dao.ProductDao;
import dao.impl.ProductDaoImpl;
import domain.Product;
import exception.ListProductException;
import util.pageHelp;

public class ProductService {
	private ProductDao productDao=new ProductDaoImpl();
	// 添加商品
	public void addProduct(Product p) {
		try {
			productDao.addProduct(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// 查找所有商品信息
	public List<Product>listAll() throws ListProductException{
		try {
			return productDao.searchAll();
		} catch (SQLException e) {
			
			throw new ListProductException("查询商品失败");
		}
	}
	// 条件查询
	public List<Product>findProductByCondition(String id, String category,String name, 
			String minprice, String maxprice){
		List<Product>products=null;
		try {
			products=productDao.findProductByManyCondition(id, category, name, minprice, maxprice);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}
	
	//编辑
	public void editProduct(Product product) {
		try {
			productDao.editProduct(product);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//根据id查找
	public Product findProductByid(String p_id) throws FindProductByIdException {
		try {
			return productDao.findProductById(p_id);
		} catch (Exception e) {
			throw new FindProductByIdException("根据id查找商品失败");
		}
	}
	//根据id删除
	public void deleteProductById(String p_id) {
		try {
			productDao.deleteProduct(p_id);
		} catch (SQLException e) {
			//RunTimeException：运行时异常，又称不受检查异常，不受检查！
			throw new RuntimeException("后台系统根据id删除商品信息失败！");
		}
	}
	// 分页操作
		public pageHelp findProductByPage(int currentPage, int currentCount,
				String category) {
			pageHelp bean = new pageHelp();
			// 封装每页显示数据条数
			bean.setCurrentCount(currentCount);
			// 封装当前页码
			bean.setCurrentPage(currentPage);
			// 封装当前查找类别
			bean.setCategory(category);
			try {
				// 获取总条数
				int totalCount = productDao.findAllCount(category);
				bean.setTotalCount(totalCount);
				// 获取总页数
				int totalPage = (int) Math.ceil(totalCount * 1.0 / currentCount);
				bean.setTotalPage(totalPage);
				// 获取当前页数据
				List<Product> ps = productDao.findByPage(currentPage, currentCount,
						category);
				bean.setPs(ps);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return bean;
		}
}
