package service;




import javax.security.auth.login.LoginException;


import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.User;
import exception.registerException;


public class UserService {
	
	private UserDao userDao=new UserDaoImpl();
	
	// 注册操作
	public void register(User user)throws registerException{
		try {
			// 调用dao完成注册操作
			userDao.addUser(user);
		} catch (Exception e) {
			throw new registerException("注冊失败");
		}
	}
	
	//登录
	public User login(String username, String password) throws LoginException {
		User user=null;
		try {
			//根据登录时表单输入的用户名和密码，查找用户
			user=userDao.selectOneByUsername(username,password);
			if(user!=null) {
				return user;				
			}	
			throw new LoginException("用户名或密码错误");
		} catch (Exception e) {
			throw new LoginException("登录失败");
		}



	}
}
