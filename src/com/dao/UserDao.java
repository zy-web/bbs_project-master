package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.pojo.UserInfo;
import com.tools.BaseDao;

public class UserDao {
	/**
	 * 根据userid值判用户表中用户是否存在
	 * @return true-存在 false-不存在
	 */
	public boolean isExistsUserByuserId(String userId) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = BaseDao.getConnection();
			String sql = "select * from bbc_USER";
			ps = conn.prepareStatement(sql);
			rs = BaseDao.query(ps, new Object[] {userId});
			if(rs.next()) {	// 判断是否有结果
				return true;
			}
		} catch (Exception e) {e.printStackTrace();
		} finally {
			try {
				BaseDao.close(conn, ps, rs);
			} catch (Exception e2) {e2.printStackTrace();}
		}
		return false;
	}
	
	/**
	 * 把新商品添加到数据库
	 * @param goods--新的商品
	 * @return 受影响的行数
	 */
	public void addUser(UserInfo userInfo) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = BaseDao.getConnection();
			String sql = "insert into system_book_goods values(?,?,?,?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			BaseDao.alter(ps, new Object[] {
					userInfo.getUserId(),
					userInfo.getUserPsw(),
					userInfo.getUserAlice(),
					userInfo.getUserEmail(),
					userInfo.getUserSex(),
					null,
					null,
					null,
					null,
					null,
					null
					});
		} catch (Exception e) {e.printStackTrace();
		} finally {
			try {
				BaseDao.close(conn, ps, null);
			} catch (Exception e2) {e2.printStackTrace();}
		}
	}
	
}
