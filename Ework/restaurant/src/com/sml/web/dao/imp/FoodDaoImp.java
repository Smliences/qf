package com.sml.web.dao.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.sml.web.dao.FoodDao;
import com.sml.web.jdbcUtils.JdbcUtils;
import com.sml.web.pojo.Cuisine;
import com.sml.web.pojo.Food;

public class FoodDaoImp implements FoodDao{
	JdbcUtils jdbc = new JdbcUtils();
	@Override
	public List<Food> queryList() {
		String sql = "select * from food";
		List<HashMap<String, Object>> list = jdbc.select(sql, null);
		List<Food> foodList = new ArrayList<Food>();
		for (HashMap<String, Object> hashMap : list) {
			Food food = new Food();
			food.setF_cid(String.valueOf(hashMap.get("f_cid")));
			food.setF_desc((String)hashMap.get("f_desc"));
			food.setF_id(Integer.valueOf(String.valueOf(hashMap.get("f_id"))));
			food.setF_name((String)hashMap.get("f_name"));
			food.setF_price((String)hashMap.get("f_price"));
			food.setF_vprice((String)hashMap.get("f_vprice"));
			foodList.add(food);
		}
		if (foodList != null && foodList.size() > 0) {
			return foodList;
		}
		return null;
	}

	@Override
	public void insert(Food e) {
		String sql = "insert into food(f_name,f_price,f_vprice,f_desc,f_img_url,f_cid) values(?,?,?,?,?,?)";
		ArrayList<Object> arrs = new ArrayList<Object>();
		arrs.add(e.getF_name());
		arrs.add(e.getF_price());
		arrs.add(e.getF_vprice());
		arrs.add(e.getF_desc());
		arrs.add(e.getF_img_url());
		arrs.add(e.getF_cid());
		jdbc.update(sql, arrs);
	}

	@Override
	public Food queryById(int id) {
		String sql = "select * from food where f_id = ?";
		ArrayList<Object> arrs = new ArrayList<Object>();
		arrs.add(id);
		List<HashMap<String, Object>> list = jdbc.select(sql, arrs);
		Food food = new Food();
		food.setF_cid(String.valueOf(list.get(0).get("f_cid")));
		food.setF_desc((String)list.get(0).get("f_desc"));
		food.setF_name((String)list.get(0).get("f_name"));
		food.setF_price((String)list.get(0).get("f_price"));
		food.setF_vprice((String)list.get(0).get("f_vprice"));
		return food;
	}

	@Override
	public void update(Food e) {
	
		
	}

	@Override
	public void deleteById(int id) {
		String sql = "delete from food where f_id = ?";
		ArrayList<Object> arrs = new ArrayList<Object>();
		arrs.add(id);
		jdbc.update(sql, arrs);
		
	}

	@Override
	public List<Cuisine> queryCuisineList() {
		String sql = "select * from cuisine";
		List<Cuisine> cuisineList = new ArrayList<Cuisine>();
		List<HashMap<String, Object>> list = jdbc.select(sql, null);
		for (HashMap<String, Object> hashMap : list) {
			Cuisine cuisine = new Cuisine();
			cuisine.setC_id(Integer.valueOf(String.valueOf(hashMap.get("c_id"))));
			cuisine.setC_name((String)hashMap.get("c_name"));
			cuisineList.add(cuisine);
		}
		if (cuisineList != null && cuisineList.size() > 0) {
			return cuisineList;
		}
		return null;
	}

}
