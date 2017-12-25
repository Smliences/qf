package com.sml.ssm.pojo;

import org.springframework.stereotype.Component;

/**
 * Author: sml
 * date: 2017年12月8日
 * time: 下午4:14:05
**/
@Component
public class Option {
	private int o_id;
	private String content;
	private int count;
	private int v_id;
	public int getO_id() {
		return o_id;
	}
	public void setO_id(int o_id) {
		this.o_id = o_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getV_id() {
		return v_id;
	}
	public void setV_id(int v_id) {
		this.v_id = v_id;
	}
	@Override
	public String toString() {
		return "Option [o_id=" + o_id + ", content=" + content + ", count=" + count + ", v_id=" + v_id + "]";
	}
	
	

}
