package com.sml.dao.impl;

import java.util.List;

import javax.xml.registry.infomodel.User;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.sml.dao.UserDao;

/**
 * Author: sml
 * date: 2017年12月8日
 * time: 下午4:14:05
**/

public class UserDaoImpl implements UserDao{
	private HibernateTemplate ht;
	
	public HibernateTemplate getHt() {
		return ht;
	}

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}

	public List<User> getUserList() {
		List<User> userList = (List<User>) ht.find("from User");
		return userList;
	}


}
