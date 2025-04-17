package dao;

import java.sql.SQLException;



import domain.User;

public interface UserDao {
	// 添加用户
	public void addUser(User user) throws SQLException;
	// 根据用户名查询
	User selectOneByUsername(String username,String password) throws SQLException;
	
}
