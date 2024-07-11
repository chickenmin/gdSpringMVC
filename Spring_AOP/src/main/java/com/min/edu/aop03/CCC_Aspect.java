package com.min.edu.aop03;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;	//spring과 aop는 다름

@Aspect
public class CCC_Aspect {

	/*
	 * 메소드가 실행되기 전에 작동되는 ccc	
	 */
	@Before("execution(public void com.min.edu.aop03.*.*(..))")
	public void beforeMethod() {
		System.out.println("◆ 메소드를 실행한다");
	}
	
	
	
	
	
	/*
	 * 메소드가 실행 후 예외가 발생했을때 작동되는 ccc
	 */
	@AfterThrowing(pointcut = "execution(public void com.min.edu.aop03.*.*(..))", throwing = "e")
	public void exceptionMethod(Exception e) {
		System.out.println("◆ 오류 발생"+e.getMessage());
		}
	
	
	
	
	/*
	 * 메소드 실행완료 되었을때 작동되는 ccc
	 */
	@After("execution(public void com.min.edu.aop03.*.*(..))")
	public void afterMethod() {
		System.out.println("◆ 종료");
		}

}



