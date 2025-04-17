package dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import dao.UserDao;
import domain.User;
import util.DataSourceUtils;

public class UserDaoImpl implements UserDao {

	private QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
	
	@Override
	public void addUser(User user) throws SQLException {
		String sql="insert into user(username,password,gender,email,telephone,introduction)values(?,?,?,?,?,?)";
		int row=runner.update(sql,user.getUsername(),user.getPassword(),user.getGender(),user.getEmail(),user.getTelephone(),user.getIntroduce());
		if(row==0) {
			throw new RuntimeException();
		}
	}

	@Override
	public User selectOneByUsername(String username,String password)throws SQLException {
		String sql="select * from user where username=? and password=?";
		return runner.query(sql, new BeanHandler<User>(User.class),username,password);
	}

}
