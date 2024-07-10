package com.min.edu.anno06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Anno06_Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/min/edu/anno06/Anno06.xml");
//		 IUserService service01 =context.getBean("userServiceImpl",UserServiceImpl.class);
//		 service01.addUser();
		
		
//		 IUserService service02 =context.getBean("userServiceImpl",UserServiceImpl.class);
//		 service02.addUser();

//		 UserService service = context.getBean(UserService.class);	//bean 이름이 따로 없고 @configuration으로 설정했기에 클래스 타입을 가져와야함
//		 service.printUser01();
//		 service.printUser02();
		 
		
//		ApplicationContext configurationBeanMethod = 
//				new AnnotationConfigApplicationContext("UserService.class"); //빈으로 등록된 printUser01 메소드만 호출됨
//	
		UserServiceImpl2 impl2 =
		context.getBean("UserServiceImpl2",UserServiceImpl2.class);
		
		System.out.println(impl2);	//메소드가 먼저 실행됨
	}

}
