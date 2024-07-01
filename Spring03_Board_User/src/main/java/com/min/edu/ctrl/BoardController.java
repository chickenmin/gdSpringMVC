package com.min.edu.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BoardController {
	
	@GetMapping(value = "/home.do")
	public String home() {
		log.info("BoardController home.do GET 요청");
		return "home";
	}
}
