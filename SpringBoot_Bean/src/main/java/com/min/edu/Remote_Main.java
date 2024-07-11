package com.min.edu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.min.edu.anno04.Radio;

@ComponentScan(basePackages = "com.min.edu.anno04")
//@ComponentScan(basePackages = {"com.min.edu.anno04","com.min.edu.anno05"})	//안좋은 방법이지만 여러개 연결할대
public class Remote_Main {

	public static void main(String[] args) {
		ApplicationContext bean =
				 new AnnotationConfigApplicationContext(Remote_Main.class);
		Radio obj = bean.getBean("radio",Radio.class);
		obj.powerOff();
		obj.powerOn();
		
	}

}
