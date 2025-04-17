package dao;

import java.sql.SQLException;
import java.util.List;

import domain.Notices;


public interface NoticeDao {
	
	 // 查找公告
	public List<Notices> getAllNotices() throws SQLException;
	// 添加公告
	public void addNotice(Notices n) throws SQLException;
	//删除公告
	public void deleteNotice(String n_id) throws SQLException;
	//根据id查找
	public Notices findNoticeById(String n_id)throws SQLException;
	//编辑公告
	public void editNotice(Notices n)throws SQLException;
	//前台系统，查询最新添加或修改的一条公告
	public Notices getRecentNotice() throws SQLException;
}
