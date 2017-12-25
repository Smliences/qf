package com.sml.onetoone;

/**
 * Author: sml
 * date: 2017年12月8日
 * time: 下午4:14:05
**/

public class User {
	private int uid;
	private String username;
	private String password;
	private Addresses address;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Addresses getAddress() {
		return address;
	}
	public void setAddress(Addresses address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", address=" + address + "]";
	}
	
	

}
