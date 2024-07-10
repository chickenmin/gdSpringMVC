package com.min.edu.bean03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Bean03_Main {

	public static void main(String[] args) {
		ApplicationContext context =
				new ClassPathXmlApplicationContext("com/min/edu/bean03/bean03.xml");
		
		  UserServiceImpl service= context.getBean("userServiceImpl",UserServiceImpl.class);
		  service.getUser();
	}

}
