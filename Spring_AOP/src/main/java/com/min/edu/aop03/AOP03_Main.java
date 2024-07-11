package com.min.edu.aop03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOP03_Main {

	public static void main(String[] args) {
		ApplicationContext context =
				 new ClassPathXmlApplicationContext("com/min/edu/aop03/aop-context.xml");
		IHumanWork cto = context.getBean("cTO",IHumanWork.class);
		cto.work();
		
		IHumanWork employees = context.getBean("employees",IHumanWork.class);
		employees.work();
		
		
	}

}
