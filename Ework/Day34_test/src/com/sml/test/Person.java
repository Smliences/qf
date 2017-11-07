package com.sml.test;


public class Person extends Object{
	
	private int id;
	public String name;
	
	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	private Person() {}
	
	public static void eat() {
		System.out.println("中午吃谷婆婆");
	}
	
	public void sleep(int num) {
		System.out.println(name + "每天睡" + num + "个小时"); 
	} 
	
	private void game() {
		System.out.println("大吉大利，今晚吃鸡");
	}
	

	@Override
	public String toString() {
		return "ID:" + id + " Name:" + name;
	}
}
