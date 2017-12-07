package com.sml.mapper;

import java.util.List;

import com.sml.pojo.User;

public interface UserMapper {
	public void insertUser(User user);
	public List<User> selectUserByUsername(String username);
	public void updateUser(User user);
	public List<User> selectUserGroupByName(String username);
}
