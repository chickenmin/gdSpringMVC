package com.min.edu.aop02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOP02_Main {
	public static void main(String[] args) {
		ApplicationContext context =
				new ClassPathXmlApplicationContext("com/min/edu/aop02/aop-context.xml");
		/*
		 *  ####Spring bean에 의해서 Auto-proxy된 객체는 java의 proxy가 아니기 때문에 jdk.proxy.$~~오류 발생
		 *  반드시 인터페이스를 통해서 하위의 메소드를 실행하는 방법으로 작성해야 합니다(OCP)
		 */
		
//		 IHumanWork emp = context.getBean("employees",Employees.class);	=>오류
		IHumanWork emp = context.getBean("employees",IHumanWork.class);
		emp.work();
		
		IHumanWork cto = context.getBean("cTO",IHumanWork.class);
		emp.work();
		 
	}

}
