package com.min.edu.bean01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Bean01_Main {

	public static void main(String[] args) {
		//기존방식의 객체의 생성과 사용 (POJO)
//		IMessageBean message = new MessageBeanImpl("", "");
//		System.out.println(message);
//		message.call();
		
		//Spring Container에 Spring Bean Configuration을 통해서 bean을 생성하고 관리하게 된다
		ApplicationContext context = new ClassPathXmlApplicationContext("com/min/edu/bean01/bean01.xml");
		
		//bean의 호출과 사용
		IMessageBean coffeeA= (IMessageBean) context.getBean("Americano");
		coffeeA.call();
		
		IMessageBean coffeeAra = context.getBean("Arabica",IMessageBean.class);
		coffeeAra.call();
		
	}
}
