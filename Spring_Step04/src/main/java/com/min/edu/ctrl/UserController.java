package com.min.edu.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/com/min/edu/{user}")
@Controller
public class UserController {

	
	//TODO 024 요청된 주소에서 @PathVariable을 통해서 주소에서 {}으로 선언된 범위를 값으로 사용할 수 있다
	@GetMapping(value = "/pathVariable.do")
	public String user(@PathVariable("user") String path) {
		log.info("주소에서 parameter를 추출 {}",path);
		return path+"/userInfo";	
		//인덱싱과 주소에서 추출하는 방식 많이 씀
	
	}
}
