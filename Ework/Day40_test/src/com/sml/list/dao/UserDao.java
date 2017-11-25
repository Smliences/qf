package com.sml.list.dao;

import java.util.HashMap;
import java.util.Map;

public class UserDao {
	Map<String, String> map = new HashMap<String, String>();
	public UserDao() {
		map.put("zhangsan", "123");
		map.put("lisi", "123");
		map.put("sunshangxiang", "123");
	}
	
	public boolean findUserByUser(String username, String password) {

		String existPassword = map.get(username);

		if (password.equals(existPassword)) {
			return true;
		}
		return false;
	}
	
	public Map<String, String> findList() {
		return map;
	}
	
}
