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
		System.out.println("����Թ�����");
	}
	
	public void sleep(int num) {
		System.out.println(name + "ÿ��˯" + num + "��Сʱ"); 
	} 
	
	private void game() {
		System.out.println("�󼪴���������Լ�");
	}
	

	@Override
	public String toString() {
		return "ID:" + id + " Name:" + name;
	}
}
