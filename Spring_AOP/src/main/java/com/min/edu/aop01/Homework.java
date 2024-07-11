package com.min.edu.aop01;

public class Homework {

	/*
	 * ◆ : 반복적으로 실행되는 부기능
	 * ◎ : 주기능
	 */
	public void workProcess() {
		System.out.println("◆ 업무 준비 운동");
		
		
		try {
			System.out.println("◎ 주된 업무를 합니다");
		} catch (Exception e) {
			System.out.println("◆ 업무중 감기 조퇴!!");
		}finally {
			System.out.println("◆ 업무 종료~");
			
		}

	}
}
