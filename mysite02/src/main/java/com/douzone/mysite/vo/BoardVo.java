package com.douzone.mysite.vo;

import java.util.Date;

public class BoardVo {
	private int no;
	private String title;
	private String contents;
	private int hit;
	private Date regDate;
	private int groupNo;
	private int orderNo;
	private int depth;
	private int userNo;
	private boolean delete_check;

	public BoardVo() {
		super();
	}

	public BoardVo(String title, String contents, int hit, Date regDate, int groupNo, int orderNo, int depth,
			int userNo, boolean delete_check) {
		super();
		this.title = title;
		this.contents = contents;
		this.hit = hit;
		this.regDate = regDate;
		this.groupNo = groupNo;
		this.orderNo = orderNo;
		this.depth = depth;
		this.userNo = userNo;
		this.delete_check = delete_check;
	}

	public boolean isDelete_check() {
		return delete_check;
	}

	public void setDelete_check(boolean delete_check) {
		this.delete_check = delete_check;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getGroupNo() {
		return groupNo;
	}

	public void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	@Override
	public String toString() {
		return "BoardVo [no=" + no + ", title=" + title + ", contents=" + contents + ", hit=" + hit + ", regDate="
				+ regDate + ", groupNo=" + groupNo + ", orderNo=" + orderNo + ", depth=" + depth + ", userNo=" + userNo
				+ ", delete_check=" + delete_check + "]";
	}

}