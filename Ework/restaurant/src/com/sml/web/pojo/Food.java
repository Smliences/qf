package com.sml.web.pojo;

public class Food {
	private int f_id;
	private String f_name;
	private String f_vprice;
	private String f_price;
	private String f_desc;
	private String f_img_url;
	private String f_cid;
	public int getF_id() {
		return f_id;
	}
	public void setF_id(int f_id) {
		this.f_id = f_id;
	}
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public String getF_vprice() {
		return f_vprice;
	}
	public void setF_vprice(String f_vprice) {
		this.f_vprice = f_vprice;
	}
	public String getF_desc() {
		return f_desc;
	}
	public void setF_desc(String f_desc) {
		this.f_desc = f_desc;
	}
	public String getF_img_url() {
		return f_img_url;
	}
	public void setF_img_url(String f_img_url) {
		this.f_img_url = f_img_url;
	}
	public String getF_cid() {
		return f_cid;
	}
	public void setF_cid(String f_cid) {
		this.f_cid = f_cid;
	}
	public String getF_price() {
		return f_price;
	}
	public void setF_price(String f_price) {
		this.f_price = f_price;
	}
	@Override
	public String toString() {
		return "Food [f_id=" + f_id + ", f_name=" + f_name + ", f_vprice=" + f_vprice + ", f_price=" + f_price
				+ ", f_desc=" + f_desc + ", f_img_url=" + f_img_url + ", f_cid=" + f_cid + "]";
	}

	
	
}
