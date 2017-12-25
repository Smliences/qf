package com.sml.onetoone;

/**
 * Author: sml
 * date: 2017年12月8日
 * time: 下午4:14:05
**/

public class Addresses {
	private int aid;
	private String address;
	private User user;
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Addresses [aid=" + aid + ", address=" + address + ", user=" + user + "]";
	}

	
}
