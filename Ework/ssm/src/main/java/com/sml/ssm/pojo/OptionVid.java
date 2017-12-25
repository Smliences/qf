package com.sml.ssm.pojo;

import java.util.Arrays;

import org.springframework.stereotype.Component;

/**
 * Author: sml
 * date: 2017年12月8日
 * time: 下午4:14:05
**/
@Component
public class OptionVid {
	private String [] options;
	private int v_id;
	public String[] getOptions() {
		return options;
	}
	public void setOptions(String[] options) {
		this.options = options;
	}
	public int getV_id() {
		return v_id;
	}
	public void setV_id(int v_id) {
		this.v_id = v_id;
	}
	@Override
	public String toString() {
		return "OptionVid [options=" + Arrays.toString(options) + ", v_id=" + v_id + "]";
	}
	
}
