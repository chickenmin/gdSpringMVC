package com.min.edu.anno04;

import org.springframework.stereotype.Component;

@Component
public class Television implements IFunction {

	@Override
	public void powerOn() {
		System.out.println("텔리비젼을 켜다");
	}

	@Override
	public void powerOff() {
		System.out.println("텔리비젼을 끄다");

	}

}
