package com.sml.ssm.pojo;

import org.springframework.stereotype.Component;

/**
 * Author: sml
 * date: 2017年12月8日
 * time: 下午4:14:05
**/
@Component
public class Vote {
	private int v_id;
	private String title;
	public int getV_id() {
		return v_id;
	}
	public void setV_id(int v_id) {
		this.v_id = v_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "Vote [v_id=" + v_id + ", title=" + title + "]";
	}
	
	

}
