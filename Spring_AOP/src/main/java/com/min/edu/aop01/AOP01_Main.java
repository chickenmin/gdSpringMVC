package com.min.edu.aop01;

public class AOP01_Main {

	public static void main(String[] args) {
		System.out.println("◆ 프로그램을 시작");
		
		Homework work = new Homework();
		work.workProcess();
		
		System.out.println("◆ 프로그램을 종료");
	}

}
