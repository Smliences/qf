package com.sml.web.test;

import java.util.ArrayList;

import org.junit.Test;

import com.sml.web.jdbcUtils.JdbcUtils;
import com.sml.web.pojo.Cuisine;

public class TestDemo {
	@Test
	public void run1() {
		Cuisine e = new Cuisine();
		e.setC_id(12);
		e.setC_name("粤菜");
		JdbcUtils jdbc = new JdbcUtils();
		String sql = "insert into cuisine(c_id,c_name) values(?,?)";
		ArrayList<Object> arrs = new ArrayList<Object>();

		arrs.add(e.getC_id());
		arrs.add(e.getC_name());
		jdbc.update(sql, arrs);
	}
}
