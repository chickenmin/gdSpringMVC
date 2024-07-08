package com.min.edu.ctrl;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.min.edu.model.service.IUserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UserController {
   
	private final IUserService service;
	
	@GetMapping(value = "/loginForm.do")
	public String loginForm() {
		log.info("UserController loginForm.do 로그인 화면 이동");
		return "loginForm";
	}
	
	@GetMapping(value = "/signupForm.do")
	public String signupForm() {
		log.info("UserController signupForm.do 회원가입 화면 이동");
		 return "signupForm";
	}
	
	@GetMapping(value = "/duplicate.do")
	public String duplicate() {
		log.info("UserController duplicate.do 아이디 중복검사 화면 이동");
		return "duplication";
	}
	
	
	
	
	
}
