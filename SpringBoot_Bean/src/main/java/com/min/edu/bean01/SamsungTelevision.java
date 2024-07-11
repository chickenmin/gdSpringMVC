package com.min.edu.bean01;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SamsungTelevision implements RemoteController {

	@Override
	public FunctionExecution powerOn() {
		log.info("@Component로 생성된 SamsungTelevision powerOn");
		return new FunctionExecution("텔레비전을 켜다", "텔레비전");
	}

	@Override
	public FunctionExecution powerOff() {
		log.info("@Component로 생성된 SamsungTelevision powerOff");
		return new FunctionExecution("텔레비전을 끄다", "텔레비전");
	}
	
	
	
}
