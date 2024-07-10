package com.min.edu.bean03;

import java.util.Date;
import java.util.Properties;


public class UserDto {
	
	private String name;
	private Properties per;
	private Date myDate;	//요즘 날짜로 많이 쓰는 객체 : 근데 db에서 커런트로 받아오는게 더 중요
	private String hobby;
	
	//UserDto 객체는 반드시 name을 입력해서 사용해야한다
	public UserDto(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "UserDto [name=" + name + ", per=" + per + ", myDate=" + myDate + ", hobby=" + hobby + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Properties getPer() {
		return per;
	}

	public void setPer(Properties per) {
		this.per = per;
	}

	public Date getMyDate() {
		return myDate;
	}

	public void setMyDate(Date myDate) {
		this.myDate = myDate;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	
	

}
