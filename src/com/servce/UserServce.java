package com.servce;

import com.dao.UserDao;
import com.pojo.UserInfo;

public class UserServce {
	UserDao userDao = new UserDao();
	/**
	 * 把用户信息添加到的数据库
	 * @param goods--新买的商品
	 */
	public String addUser(UserInfo userInfo) {
		// 查找数据库中是否存在对应用户？
		if(userDao.isExistsUserByuserId(userInfo.getUserId())) {//  1、存在则修改对应的numbers加1
			return "用户已存在";
		}
		else {//  2、不存在则把新商品添加到数据库
			userDao.addUser(userInfo);
			return "已成功注册";
		}
	}

}
