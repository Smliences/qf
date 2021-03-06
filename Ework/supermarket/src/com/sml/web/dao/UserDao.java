package com.sml.web.dao;

import java.util.List;

import com.sml.web.baseinterface.BaseInterface;
import com.sml.web.pojo.PageBean;
import com.sml.web.pojo.User;

public interface UserDao extends BaseInterface<User>{
	public String queryByUsername(String username);
	public List<User> queryUserList();
	public int queryUserCount();
	public List<User> queryPageBeanlist(PageBean pageBean);
}
