package com.sml.service;

import java.util.List;

import org.apache.tomcat.jni.User;

import com.sml.dao.UserDao;

/**
 * Author: sml
 * date: 2017��12��8��
 * time: ����4:14:05
**/

public class UserService {
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
