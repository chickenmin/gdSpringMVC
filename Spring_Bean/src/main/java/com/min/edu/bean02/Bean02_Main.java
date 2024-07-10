package com.min.edu.bean02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Bean02_Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/min/edu/bean02/bean02.xml");
		
		 JobAddress dev =context.getBean(JobAddress.class);
		 System.out.println(dev);
		 
		 Object empAddr = context.getBean(JobAddress.class);
	}

}
