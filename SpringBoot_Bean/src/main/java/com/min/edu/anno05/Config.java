package com.min.edu.anno05;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
	 * Student를 사용하여 여러개의 같은 타입의 bean을 생성
	 */
@Configuration
public class Config {
	
	@Bean(name = "stu01")
	public Student student01() {
		Student stu = new Student();
		stu.setName("월요일");
		stu.setAddr("서울");
		stu.setAge(100);
		return stu;
	}
	
	@Bean(name = "stu02")
	public Student student02() {
		Student stu = new Student();
		stu.setName("화요일");
		stu.setAddr("서울");
		stu.setAge(200);
		return stu;
	}
	
	@Bean(name = "stu03")
	public Student student03() {
		Student stu = new Student();
		stu.setName("수요일");
		stu.setAddr("서울");
		stu.setAge(300);
		return stu;
	}
}
