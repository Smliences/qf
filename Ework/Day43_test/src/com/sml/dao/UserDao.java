package com.sml.dao;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDao {
	Map<String, String> map = new HashMap<String, String>();
	public UserDao() {
		map.put("sunxuhao", "123");
	}

	public boolean findPasswordByUser(String username, String password) {
		String existPassword = map.get(username);
		if (existPassword.equals(password) && !existPassword.equals("")) {
			return true;
		}
		return false;
	}

	public Map<String, String> findList(File file) {
		File[] listFiles = file.listFiles();
		Map<String, String> map = new HashMap<String, String>();
		for (File file2 : listFiles) {
			map.put(file2.getName(), file2.getAbsolutePath().replace("\\","/"));
		}
		return map;
	}
}
