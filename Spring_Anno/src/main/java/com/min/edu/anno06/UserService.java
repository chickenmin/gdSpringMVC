package com.min.edu.anno06;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserService {
	
	@Bean
	public void printUser01() {
		System.out.println("클래스에 소속된 @Bean");
	}
	public void printUser02() {
		System.out.println("클래스에 소속된 메소드");
	}

}
