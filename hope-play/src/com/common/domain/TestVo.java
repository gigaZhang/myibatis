package com.common.domain;

import java.util.Date;


/**
 * 测试vo
 * @author lph
 *
 */
public class TestVo {

	private int id;
	private String name;
	private String pwd;
	private String info;
	private Date cTm;
	private Date mTm;
	private int count;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Date getCTm() {
		return cTm;
	}
	public void setCTm(Date tm) {
		cTm = tm;
	}
	public Date getMTm() {
		return mTm;
	}
	public void setMTm(Date tm) {
		mTm = tm;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
