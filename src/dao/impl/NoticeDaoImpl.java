package dao.impl;


import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import dao.NoticeDao;
import domain.Notices;
import util.DataSourceUtils;

public class NoticeDaoImpl implements NoticeDao {

	QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
	
	//后台系统，查询所有的公告
	@Override
	public List<Notices> getAllNotices() throws SQLException {
		String sql="select * from notice order by n_time desc limit 0,10";			
		return runner.query(sql,new BeanListHandler<Notices>(Notices.class));
	}

	//后台系统，添加公告
	@Override
	public void addNotice(Notices n) throws SQLException {
		String sql = "insert into notice(title,details,n_time) values(?,?,?)";
		runner.update(sql, n.getTitle(),n.getDetails(),n.getN_time());
	}

	//后台系统，根据id删除公告
	@Override
	public void deleteNotice(String n_id) throws SQLException {
		String sql="delete from notice where n_id = ?";
		runner.update(sql,n_id);		
	}
	//后台系统，根据id查找公告
	@Override
	public Notices findNoticeById(String n_id) throws SQLException {
		String sql="select * from notice where n_id = ?";
		return runner.query(sql,new BeanHandler<Notices>(Notices.class),n_id);
	}

	//后台系统，根据id修改单个公告
	@Override
	public void editNotice(Notices n) throws SQLException {
		String sql="update notice set title=?,details=?,n_time=? where n_id=?";
		runner.update(sql, n.getTitle(),n.getDetails(),n.getN_time(),n.getN_id());
		
	}

	@Override
	public Notices getRecentNotice() throws SQLException {
		String sql = "select * from notice order by n_time desc limit 0,1";
		return runner.query(sql, new BeanHandler<Notices>(Notices.class));

	}

}
