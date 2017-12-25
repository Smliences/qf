package com.sml.service.impl;

import java.util.List;

import com.sml.dao.UserDao;
import com.sml.pojo.User;
import com.sml.service.UserService;

/**
 * Author: sml
 * date: 2017年12月8日
 * time: 下午4:14:05
**/

public class UserServiceImpl implements UserService{
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public List<User> selectAll() {
		return userDao.selectAll();
	}
	

}
