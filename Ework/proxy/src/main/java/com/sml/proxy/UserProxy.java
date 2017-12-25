package com.sml.proxy;

/**
 * Author: sml
 * date: 2017年12月8日
 * time: 下午4:14:05
**/

public class UserProxy implements User{
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public UserProxy(User user) {
		this.user = user;
	}
	public void eat() {
		System.out.println("该吃饭了");
		 user.eat();
	}

	public void study() {
		System.out.println("该睡觉了");
		user.study();
	}

}
