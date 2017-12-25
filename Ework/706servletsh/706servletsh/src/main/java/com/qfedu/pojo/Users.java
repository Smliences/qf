package com.qfedu.pojo;
// Generated 2017-12-21 16:06:22 by Hibernate Tools 5.1.0.Alpha1

import java.util.Arrays;

/**
 * Users generated by hbm2java
 */
public class Users implements java.io.Serializable {

	private Integer id;
	private String username;
	private String password;
	private Integer age;
	private byte[] photo;

	
	
	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", password=" + password + ", age=" + age + ", photo="
				+ Arrays.toString(photo) + "]";
	}

	public Users() {
	}

	public Users(String username, String password, Integer age, byte[] photo) {
		this.username = username;
		this.password = password;
		this.age = age;
		this.photo = photo;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public byte[] getPhoto() {
		return this.photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

}
