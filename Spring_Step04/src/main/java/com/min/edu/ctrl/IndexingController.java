package com.min.edu.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/user")
public class IndexingController {
	
	//TODO 005 Controller에 mapping을 호출할때 index를 통해서 구분하여 호출한다
	
//	@GetMapping(value = "/home.do")
//	to {GET [/home.do]}: There is already 'homeController' bean method => 이미 home.do와 매핑된 서블릿이 있다
	@GetMapping(value = "/logout.do")
	public String indexing() {
		log.info("IndexingController @GetMapping /logout.do");
		return "indexing";
	}
}
