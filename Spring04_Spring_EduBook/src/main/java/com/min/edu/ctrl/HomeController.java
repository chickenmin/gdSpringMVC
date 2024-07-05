package com.min.edu.ctrl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

//TODO 003
@Slf4j //lombok이 필수로 설정되어 있어야 한다
@Controller
public class HomeController {
	
//	private Logger log = LoggerFactory.getLogger(HomeController.class);

//	@RequestMapping(name = "home.do",method = RequestMethod.GET) //name/value동일 
	@GetMapping(value = "main.do")
	public String home() {
		log.info("HomeController main.do 요청");
		log.info("처음 페이지 이동 home.jsp");
		return "home";
	}
}
