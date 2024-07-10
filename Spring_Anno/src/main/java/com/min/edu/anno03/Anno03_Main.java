package com.min.edu.anno03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Anno03_Main {

	public static void main(String[] args) {
			ApplicationContext bean =
					new ClassPathXmlApplicationContext("com/min/edu/anno03/Anno03_Scan.xml");
			 NickNameProp03 prop03 = bean.getBean("NickNameProp03",NickNameProp03.class);
			 
			 System.out.println(prop03);
		
	}

}
