package com.min.edu.bean03;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements IUserService {

//	@Autowired //타입찾은 후에 이름
//	private UserDto dto; 
	
	@Resource(name = "myDto01")	//이름 찾고 타입
	private UserDto dto;
	
	
	public UserServiceImpl() {
		System.out.println("UserServiceImpl 생성");
	}
	
	
	@Override
	public void addUser(UserDto dto) {
		System.out.println("addUser 메소드 호출: "+dto);
		System.out.println("addUser 메소드 호출: "+this.dto);
	}

	@Override
	public void getUser() {
		System.out.println("getUser 메소드 호출: "+dto);
	}

}
