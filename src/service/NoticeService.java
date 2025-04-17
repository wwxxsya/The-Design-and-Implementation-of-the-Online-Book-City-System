package service;

import java.sql.SQLException;
import java.util.List;

import dao.NoticeDao;
import dao.impl.NoticeDaoImpl;
import domain.Notices;

public class NoticeService {
	
	private NoticeDao noticeDao=new NoticeDaoImpl();
	
	public List<Notices>getAllNotices(){
		try {
			return noticeDao.getAllNotices();
		} catch (SQLException e) {
			throw new RuntimeException("查询所有的公告失败！");
		}
	}
	public void addNotice(Notices n){
		try {
			noticeDao.addNotice(n);
		} catch (SQLException e) {
			throw new RuntimeException("添加公告失败!");
		}
	}
	public void deleteNotice(String n_id) {
		try {
			noticeDao.deleteNotice(n_id);
		} catch (SQLException e) {
			throw new RuntimeException("根据id删除公告失败！");
		}
	}
	public Notices findNoticeById(String n_id) {
		try {
			return noticeDao.findNoticeById(n_id);
		} catch (Exception e) {
			throw new RuntimeException("根据id查找公告失败！");
		}
	}
	public void editNotice(Notices n) {
		try {
			noticeDao.editNotice(n);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//前台系统，查询最新添加或修改的一条公告
		public Notices getRecentNotice() {
			try {
				return noticeDao.getRecentNotice();
			} catch (SQLException e) {
				throw new RuntimeException("查询最新添加或修改的一条公告失败！");
			}
		}
}
