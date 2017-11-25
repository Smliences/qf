package com.sml.web.dao.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.sml.web.dao.ProviderDao;
import com.sml.web.pojo.Provider;
import com.xml.web.untills.JdbcUtils;

public class ProviderDaoImp implements ProviderDao{
	JdbcUtils jdbc = new JdbcUtils();
	@Override
	public void insert(Provider e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Provider e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Provider> query(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Provider> queryProviderList() {
		String sql = "select * from provider";
		ArrayList<Provider> userList = new ArrayList<Provider>();
		List<HashMap<String, Object>> list = jdbc.select(sql, null);
		
		for (HashMap<String, Object> hashMap : list) {
			Provider provider = new Provider();
			provider.setPname((String)hashMap.get("pname"));
			provider.setPaddress((String)hashMap.get("paddress"));
			provider.setPdesc((String)hashMap.get("pdesc"));
			provider.setPid((int)hashMap.get("pid"));
			provider.setPlinkman((String)hashMap.get("plinkman"));
			provider.setPphone((String)hashMap.get("pphone"));
			
			userList.add(provider);
		}
		if (userList != null && userList.size() > 0)
			return userList;
		return null;
	}

}
