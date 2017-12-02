package com.sml.web.dao.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.sml.web.dao.UserDao;
import com.sml.web.pojo.PageBean;
import com.sml.web.pojo.User;
import com.xml.web.untills.JdbcUtils;

public class UserDaoImp implements UserDao {
	JdbcUtils jdbc = new JdbcUtils();
	@Override
	public void insert(User e) {
		String sql = "insert into user(username,password,sex,age,phone,address,job) "
				+ "values (?,?,?,?,?,?,?)";
		
		ArrayList<Object> arrs = new ArrayList<Object>();
		arrs.add(e.getUsername());
		arrs.add(e.getPassword()); 
		arrs.add(e.getSex());
		arrs.add(e.getAge());
		arrs.add(e.getPhone());
		arrs.add(e.getAddress());
		arrs.add(e.getJob());

		jdbc.update(sql, arrs);
	}

	@Override
	public void delete(int id) {

	}

	@Override
	public void update(User e) {

	}

	@Override
	public List<User> query(int id) {
		return null;
	}
	
	public String queryByUsername(String username) {
		String sql = "select password from user where username=?";

		ArrayList<Object> arrs = new ArrayList<Object>();
		arrs.add(username);
		List<HashMap<String, Object>> list = jdbc.select(sql, arrs);

		if (list != null && list.size() > 0) {
			return (String) list.get(0).get("password");
		}
		return null;
	}

	@Override
	public List<User> queryUserList() {
		String sql = "select * from user";
		ArrayList<User> userList = new ArrayList<User>();
		List<HashMap<String, Object>> list = jdbc.select(sql, null);
		for (HashMap<String, Object> hashMap : list) {
			User user = new User();
			user.setUsername((String)hashMap.get("username"));
			user.setAddress((String)hashMap.get("address"));
			user.setAge((int)hashMap.get("age"));
			user.setJob((String)hashMap.get("job"));
			user.setPhone((String)hashMap.get("phone"));
			user.setUid((int)hashMap.get("uid"));
			user.setSex((String)hashMap.get("sex"));
			userList.add(user);
		}
		
		if (userList != null && userList.size() > 0)
			return userList;
		return null;
	}

	@Override
	public List<User> queryPageBeanlist(PageBean pageBean) {
		String sql = "select * from user limit " 
				+ pageBean.getStartCount() + "," + pageBean.getPageCount();
		ArrayList<User> userList = new ArrayList<User>();
		List<HashMap<String, Object>> list = jdbc.select(sql, null);

		for (HashMap<String, Object> hashMap : list) {
			User user = new User();
			user.setUsername((String)hashMap.get("username"));
			user.setAddress((String)hashMap.get("address"));
			user.setAge((int)hashMap.get("age"));
			user.setJob((String)hashMap.get("job"));
			user.setPhone((String)hashMap.get("phone"));
			user.setUid((int)hashMap.get("uid"));
			user.setSex((String)hashMap.get("sex"));
			userList.add(user);
		}
		
		if (userList != null && userList.size() > 0)
			return userList;
		return null;
	}

	@Override
	public int queryUserCount() {
		List<HashMap<String, Object>> list = jdbc.select("select count(*) count from User", null);
		Number num = (Number)list.get(0).get("count");
		return  num.intValue();
	}
	
	
}
