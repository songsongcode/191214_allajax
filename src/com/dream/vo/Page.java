package com.dream.vo;

public class Page {
	private int currentpage;
	private int count;
	public Page() {
	}
	public Page(int currentpage, int count) {
		this.currentpage = (currentpage-1)*count;
		this.count = count;
	}
	public int getCurrentpage() {
		return currentpage;
	}
	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Page [currentpage=" + currentpage + ", count=" + count + "]";
	}
	
}
