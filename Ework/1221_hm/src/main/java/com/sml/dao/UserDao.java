package com.sml.dao;

import java.util.List;

import org.apache.tomcat.jni.User;
import org.springframework.orm.hibernate5.HibernateTemplate;

/**
 * Author: sml
 * date: 2017��12��8��
 * time: ����4:14:05
**/

public class UserDao {
	private HibernateTemplate ht;
	
	public HibernateTemplate getHt() {
		return ht;
	}

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}

	public List<User> getUserList() {
		return (List<User>) ht.find("from Users");
	}

}
