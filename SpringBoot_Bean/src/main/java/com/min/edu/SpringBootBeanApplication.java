package com.min.edu;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.min.edu.bean01.FunctionExecution;
import com.min.edu.bean01.SamsungAircon;
import com.min.edu.bean01.SamsungTelevision;
import com.min.edu.inject.UseBean;

@SpringBootApplication
public class SpringBootBeanApplication implements CommandLineRunner{	
	//CommandLineRunner 인터페이스는 구동시점에 실행이 되는 코드가 자바문자열 Arguments 배열에 접근해야할 필요가 있을때

	@Autowired
	private UseBean useBean;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootBeanApplication.class, args);
		//컨테이너의 생성
		ApplicationContext context1 = new AnnotationConfigApplicationContext(SamsungAircon.class);
		ApplicationContext context2 = new AnnotationConfigApplicationContext(SamsungTelevision.class);
		
		//bean의 호출
		FunctionExecution airconOn =context1.getBean("airconOn",FunctionExecution.class);
		FunctionExecution airconOff =context1.getBean("powerOff",FunctionExecution.class);
		
		//bean의 호출(@Component)
		SamsungTelevision television = context2.getBean("samsungTelevision",SamsungTelevision.class);
		
		//bean의 실행
		System.out.println(airconOn);
		System.out.println(airconOff);
		
		television.powerOff();
		television.powerOn();
		
		ApplicationContext context =
				new AnnotationConfigApplicationContext(Remote_Main.class);
		String[] beanDefinitionNames = context.getBeanDefinitionNames();
		System.out.println(Arrays.toString(beanDefinitionNames));
		
		
		ApplicationContext contextAll =
				new AnnotationConfigApplicationContext(SpringBootBeanApplication.class);
		String[] beanDefinitionNamesAll = context.getBeanDefinitionNames();
		System.out.println(Arrays.toString(beanDefinitionNamesAll));
		/*
		 * AnnotationConfigApplicationContext(SpringBootBeanApplication.class);를 통해서 생성된 bean을 확인하면
		 * 현재 적용된 프로젝트에 bean을 호출하기때문에 오류가 발생
		 */
				
	}
	
	@Override
	public void run(String... args) throws Exception {
		useBean.print();
	}
	

}
