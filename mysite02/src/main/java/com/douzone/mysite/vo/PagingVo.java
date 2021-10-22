package com.douzone.mysite.vo;

import com.douzone.mysite.dao.BoardDao;

public class PagingVo {

	private final static int pageCount = 5;
	private int NoMoreStartNum = 0;
	private int NoMoreLastNum = 0;
	private int lastPageNum = 0;

	public int getNoMoreStartNum() {
		return NoMoreStartNum;
	}

	public void setNoMoreStartNum(int noMoreStartNum) {
		NoMoreStartNum = noMoreStartNum;
	}

	public int getNoMoreLastNum() {
		return NoMoreLastNum;
	}

	public void setNoMoreLastNum(int noMoreLastNum) {
		NoMoreLastNum = noMoreLastNum;
	}

	public int getLastPageNum() {
		return lastPageNum;
	}

	public void setLastPageNum(int lastPageNum) {
		this.lastPageNum = lastPageNum;
	}

	public static int getPagecount() {
		return pageCount;
	}

	@Override
	public String toString() {
		return "PagingVo [NoMoreStartNum=" + NoMoreStartNum + ", NoMoreLastNum=" + NoMoreLastNum + ", lastPageNum="
				+ lastPageNum + "]";
	}

}