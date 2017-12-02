package com.sml.web.dao;

import java.util.List;

import com.sml.web.baseinterface.BaseDao;
import com.sml.web.pojo.Cuisine;
import com.sml.web.pojo.Food;

public interface FoodDao extends BaseDao<Food>{
	public List<Cuisine> queryCuisineList();
}
