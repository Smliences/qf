package com.sml.proxy;

import java.lang.reflect.Proxy;

/**
 * Author: sml
 * date: 2017��12��8��
 * time: ����4:14:05
**/

public class Test {
	public static void main(String[] args) {
		User user = new UserImpl();
		Handler handler = new Handler();
		handler.setUser(user);
		User proxy = (User) Proxy.newProxyInstance(Test.class.getClassLoader(),user.getClass().getInterfaces() , handler);
		proxy.eat();
	}
}
