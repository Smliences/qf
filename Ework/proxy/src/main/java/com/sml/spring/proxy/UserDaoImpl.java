package com.sml.spring.proxy;

/**
 * Author: sml
 * date: 2017年12月8日
 * time: 下午4:14:05
**/

public class UserDaoImpl implements UserDao{

	public void selectAll() {
		System.out.println("all");
	}

}
