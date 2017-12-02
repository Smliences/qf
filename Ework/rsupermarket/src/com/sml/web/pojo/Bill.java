package com.sml.web.pojo;

import com.sun.jmx.snmp.Timestamp;

public class Bill {
	private int bid;
	private String bpname;
	private String bmoney;
	private int bpcount;
	private String bprname;
	private String bpdesc;
	private String btime;
	private int bpid;
	private int isflag;
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBpname() {
		return bpname;
	}
	public void setBpname(String bpname) {
		this.bpname = bpname;
	}
	public String getBmoney() {
		return bmoney;
	}
	public void setBmoney(String bmoney) {
		this.bmoney = bmoney;
	}
	public int getBpcount() {
		return bpcount;
	}
	public void setBpcount(int bpcount) {
		this.bpcount = bpcount;
	}
	public String getBprname() {
		return bprname;
	}
	public void setBprname(String bprname) {
		this.bprname = bprname;
	}
	public String getBpdesc() {
		return bpdesc;
	}
	public void setBpdesc(String bpdesc) {
		this.bpdesc = bpdesc;
	}
	public String getBtime() {
		return btime;
	}
	public void setBtime(String btime) {
		this.btime = btime;
	}
	public int getBpid() {
		return bpid;
	}
	public void setBpid(int bpid) {
		this.bpid = bpid;
	}
	public int getIsflag() {
		return isflag;
	}
	public void setIsflag(int isflag) {
		this.isflag = isflag;
	}
	@Override
	public String toString() {
		return "Bill [bid=" + bid + ", bpname=" + bpname + ", bmoney=" + bmoney + ", bpcount=" + bpcount + ", bprname="
				+ bprname + ", bpdesc=" + bpdesc + ", btime=" + btime + ", bpid=" + bpid + ", isflag=" + isflag + "]";
	}
	
	
}
