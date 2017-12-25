package com.sml.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Author: sml
 * date: 2017年12月8日
 * time: 下午4:14:05
**/

public class StudentHandler implements InvocationHandler{
	private Student student;
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		method.invoke(student, args);
		System.out.println(":");
		return null;
	}

}
