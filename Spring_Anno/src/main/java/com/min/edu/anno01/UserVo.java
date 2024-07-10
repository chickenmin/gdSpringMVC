package com.min.edu.anno01;

import org.springframework.stereotype.Component;


	/*
	 * 이전의 bean 생성 방법은 Spring Bean Configuration을 통해서 ApplicationContext가 생성하게 된다
	 * Spring의 stereotype을 통해서 Annotation을 통해서 Bean이 되도록 생성
	 * Spring의 Annotation을 사용하기 위해서는 
	 * <context:annotation-driven> or <context:component-scan base-package="">
	 */
	
@Component
public class UserVo {
	
	private String weather;
	
	public UserVo() {
		weather = "맑음";
	}
	
	
}
