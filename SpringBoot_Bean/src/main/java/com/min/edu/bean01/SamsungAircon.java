package com.min.edu.bean01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class SamsungAircon implements RemoteController {

	public SamsungAircon() {
		log.info("삼성 에어컨 호출");
	}
	
	@Bean(name = "airconOn")
	@Override
	public FunctionExecution powerOn() {
		log.info("@Configuration의 bean으로 생성된 삼성 에어컨 powerOn");
		return new FunctionExecution("에어컨을 켜다", "에어컨");
	}

	@Bean
	@Override
	public FunctionExecution powerOff() {
		log.info("@Configuration의 bean으로 생성된 삼성 에어컨 powerOff");
		return new FunctionExecution("에어컨을 끄다", "에어컨");
	}

}
