package com.sml.dao;

import java.util.List;

import com.sml.pojo.User;

/**
 * Author: sml
 * date: 2017年12月8日
 * time: 下午4:14:05
**/

public interface UserDao {
	public List<User> selectAll();
}
