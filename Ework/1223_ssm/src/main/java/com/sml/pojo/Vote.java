package com.sml.pojo;

/**
 * Author: sml
 * date: 2017年12月8日
 * time: 下午4:14:05
**/

public class Vote {
	private int v_id;
	private String title;
	private long version;
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
	public long getVersion() {
		return version;
	}
	public void setVersion(long version) {
		this.version = version;
	}
	@Override
	public String toString() {
		return "Vote [v_id=" + v_id + ", title=" + title + ", version=" + version + "]";
	}
	
	
	
}
