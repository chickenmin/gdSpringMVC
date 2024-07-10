package com.min.edu.anno06;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

/*
 *  4.3이후에 생성 주입처리 방법
 *  멤버 필드에 final로 선언을 하고 lombok 생성자 주입을 통해서 한번만 받는다
 *  
 *  생성자 주입의 장점
 *  	1)순환 참조 방지
 *  	2) 테스트 코드를 작성하기 쉬움
 *  	3) 이상코드 제거
 *  	4) 객체 변이 방지(final)
 */

@Component(value ="UserServiceImpl2")
@RequiredArgsConstructor
public class UserServiceImpl2 implements IUserService{

	private final UserDto dto;
	
	@Override
	public void addUser() {
	}

	@Override
	public String toString() {
		return "UserServiceImpl2 [dto=" + dto + "]";
	}
	
	
}
