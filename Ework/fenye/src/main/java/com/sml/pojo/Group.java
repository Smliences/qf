package com.sml.pojo;

import java.util.List;

public class Group {
	private int id;
	private String name;
	private int size;
	private List<User> userList;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + ", size=" + size + ", userList=" + userList + "]";
	}
	
	
}
