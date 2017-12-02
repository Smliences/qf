package com.sml.web.pojo;

public class Provider {
	private int pid;
	private String pname;
	private String pdesc;
	private String plinkman;
	private String pphone;
	private String paddress;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPdesc() {
		return pdesc;
	}
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}
	public String getPlinkman() {
		return plinkman;
	}
	public void setPlinkman(String plinkman) {
		this.plinkman = plinkman;
	}
	public String getPphone() {
		return pphone;
	}
	public void setPphone(String pphone) {
		this.pphone = pphone;
	}
	public String getPaddress() {
		return paddress;
	}
	public void setPaddress(String paddress) {
		this.paddress = paddress;
	}
	@Override
	public String toString() {
		return "Provider [pid=" + pid + ", pname=" + pname + ", pdesc=" + pdesc + ", plinkman=" + plinkman + ", pphone="
				+ pphone + ", paddress=" + paddress + "]";
	}

	
}
