package com.sml.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Author: sml
 * date: 2017年12月8日
 * time: 下午4:14:05
**/

public class Handler implements InvocationHandler{
	
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println(";");
		method.invoke(user, args);
		return null;
	}
	

}
