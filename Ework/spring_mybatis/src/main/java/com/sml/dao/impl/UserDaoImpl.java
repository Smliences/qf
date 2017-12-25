package com.sml.dao.impl;

import java.util.List;

import com.sml.commons.MybatisUtils;
import com.sml.dao.UserDao;
import com.sml.pojo.User;

/**
 * Author: sml
 * date: 2017年12月8日
 * time: 下午4:14:05
**/

public class UserDaoImpl implements UserDao{

	public List<User> selectAll() {
		UserDao userDao = MybatisUtils.createFactory().getMapper(UserDao.class);
		return userDao.selectAll();
	}

}
