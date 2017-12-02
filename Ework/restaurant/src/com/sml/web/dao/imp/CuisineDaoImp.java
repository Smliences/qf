package com.sml.web.dao.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.sml.web.dao.CuisineDao;
import com.sml.web.jdbcUtils.JdbcUtils;
import com.sml.web.pojo.Cuisine;

public class CuisineDaoImp implements CuisineDao {
	private JdbcUtils jdbc = new JdbcUtils();
	@Override
	public List<Cuisine> queryList() {
		String sql = "select * from cuisine";
		List<HashMap<String, Object>> list = jdbc.select(sql, null);
		List<Cuisine> cuisineList = new ArrayList<Cuisine>();

		for (HashMap<String, Object> hashMap : list) {
			Cuisine cuisine = new Cuisine();
			cuisine.setC_id(Integer.parseInt(String.valueOf(hashMap.get("c_id"))));
			cuisine.setC_name((String)hashMap.get("c_name"));
			cuisineList.add(cuisine);
		}
		if (cuisineList != null && cuisineList.size() > 0) {
			return cuisineList;
		}
		return null;
	}

	@Override
	public void insert(Cuisine e) {
		String sql = "insert into cuisine(c_name) values(?)";
		ArrayList<Object> arrs = new ArrayList<Object>();

		arrs.add(e.getC_name());
		jdbc.update(sql, arrs);
	}

	@Override
	public Cuisine queryById(int id) {
		String sql = "select * from cuisine where c_id = ?";
		ArrayList<Object> arrs = new ArrayList<Object>();
		arrs.add(id);
		
		List<HashMap<String, Object>> list = jdbc.select(sql, arrs);
		Cuisine cuisine = new Cuisine();
		cuisine.setC_name((String)list.get(0).get("c_name"));
		cuisine.setC_id(Integer.valueOf(String.valueOf(list.get(0).get("c_id"))));
		return cuisine;
	}

	@Override
	public void update(Cuisine e) {
		String sql = "update cuisine set c_name = ? where c_id = ?";
		ArrayList<Object> arrs = new ArrayList<Object>();
		arrs.add(e.getC_name());
		arrs.add(e.getC_id());
		jdbc.update(sql, arrs);
		
	}

	@Override
	public void deleteById(int id) {
		String sql = "delete from cuisine where c_id= ?";
		ArrayList<Object> arrs = new ArrayList<Object>();
		arrs.add(id);
		jdbc.update(sql, arrs);
	}

}
