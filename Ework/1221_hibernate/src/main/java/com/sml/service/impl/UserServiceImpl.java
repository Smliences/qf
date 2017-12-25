package com.sml.service.impl;

import java.util.List;

import javax.xml.registry.infomodel.User;

import com.sml.dao.UserDao;
import com.sml.service.UserService;

/**
 * Author: sml
 * date: 2017��12��8��
 * time: ����4:14:05
**/

public class UserServiceImpl implements UserService{
	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public List<User> getUserList() {
		return userDao.getUserList();
	}


}
