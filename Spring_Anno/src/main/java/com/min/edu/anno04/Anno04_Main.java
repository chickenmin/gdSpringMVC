package com.min.edu.anno04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Anno04_Main {

	public static void main(String[] args) {
		ApplicationContext context = 
				 new ClassPathXmlApplicationContext("com/min/edu/anno04/Anno04.xml");
		
		IFunction tel =	context.getBean("television",IFunction.class);
		IFunction radio =	context.getBean("radio",IFunction.class);
		tel.powerOff();
		radio.powerOff();
		
	}

}
