package com.sml.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {
	public static void main(String[] args) throws Exception {
		Class clazz = Class.forName("com.sml.test.Person");
		Field[] declaredFields = clazz.getDeclaredFields();
		Field name = clazz.getDeclaredField("name");
		Constructor c1 = clazz.getDeclaredConstructor(null);
		c1.setAccessible(true);
		Person p = (Person) c1.newInstance(null);
		name.set(p, "lisi");
		System.out.println(p);
		
		Method game = clazz.getDeclaredMethod("game", null);
		game.setAccessible(true);
		game.invoke(p, null);
		Method sleep = clazz.getMethod("sleep", int.class);
		sleep.invoke(p, 4);
		
		
	}
}
