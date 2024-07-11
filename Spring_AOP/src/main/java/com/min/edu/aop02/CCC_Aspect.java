package com.min.edu.aop02;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class CCC_Aspect implements MethodInterceptor {

	//org.aopalliance.intercept.MethodInterceptor를 통해서 주 관심사용 Auto-proxy를 통해서 weaving을 하여 하나의 객체로 만들어준다
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object resultObj = null;
		
		System.out.println("◆ 메소드를 실행한다");
		
		try {
			resultObj = invocation.proceed();
		} catch (Throwable e) {
			System.out.println("◆ 오류 발생"+e);
		}finally {
			System.out.println("◆ 종료");
		}
		
		return resultObj;
	}

	
}
