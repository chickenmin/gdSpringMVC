package com.min.edu.anno06;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class UserServiceImpl implements IUserService{
	
	//멤버 필드 주입
//	@Autowired(required = false)
//	@Autowired
//	@Qualifier("userDto")
	
//	@Resource(name = "userDto")
	private UserDto dto01;
	
	//생성자 주입 : 최근에 자주 사용
	@Autowired
	public UserServiceImpl(UserDto dto01) {
		this.dto01 = dto01;
	}
	
	//setter주입
	@Autowired
	public void setDto01(UserDto dto01) {
		System.out.println("set메소드");
		this.dto01 = dto01;
	}
	
	@Override
	public void addUser() {
		System.out.println("추가된 멤버 : "+dto01.getName());
	}
	
}
