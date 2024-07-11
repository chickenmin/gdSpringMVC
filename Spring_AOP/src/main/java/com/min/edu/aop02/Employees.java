package com.min.edu.aop02;

public class Employees implements IHumanWork {

	@Override
	public void work() {
		System.out.println("◎ 회사에 각 담당 역할을 수행한다고");
	}

}
