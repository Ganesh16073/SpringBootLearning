package com.main.entity;

import org.springframework.stereotype.Component;

@Component
public class Alieen {

	private int aid;
	private String aname;
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	@Override
	public String toString() {
		return "Alieen [aid=" + aid + ", aname=" + aname + "]";
	}
	
	
}
