package com.sml.spring.proxy;

/**
 * Author: sml
 * date: 2017年12月8日
 * time: 下午4:14:05
**/

public class UserDaoInfo {
	public void pre() {
		System.out.println("pre..");
	} 
	
	public void suf() {
		System.out.println("suf..");
	}
}
