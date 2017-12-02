package com.sml.web.pojo;

public class PageBean {
	//总记录条数
	private int totalCount;
	//单页记录数
	private int pageCount;
	//页数
	private int pageNum;
	//总页数
	private int totalNum;
	//开始条数
	private int startCount;

	public int getTotalCount() {
		return totalCount;
	}
	
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	
	
	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getStartCount() {
		return startCount;
	
	}
	
	public int getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(int totalNum) {
		if (totalCount % pageCount == 0) {
			this.totalNum = totalCount / pageCount;
			return ;
		}
		this.totalNum = totalCount / pageCount  + 1;
	}
	
	public void setStartCount(int startCount) {
		this.startCount = pageNum * pageCount;
	}

	public PageBean(int totalCount, int pageCount, int pageNum) {
		this.totalCount = totalCount;
		this.pageCount = pageCount;
		this.pageNum = pageNum;
		setTotalNum(totalCount);
		setStartCount(pageNum);
	}
	@Override
	public String toString() {
		return "PageBean [totalCount=" + totalCount + ", totalNum=" + totalNum + ", pageCount=" + pageCount
				+ ", pageNum=" + pageNum + ", startCount=" + startCount + "]";
	}
	
}
