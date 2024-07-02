package com.min.edu.ctrl;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.min.edu.model.service.IUserService;
import com.min.edu.vo.UserVo;

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
	
	@PostMapping(value = "/signUp.do")
	public String signUp(UserVo vo,HttpServletResponse response) throws IOException {
		log.info("UserController signUp.do 회원가입 완료 이동");
		int n=service.signupMember(vo);
		
		if (n == 1) {
			return "redirect:/loginForm.do";
		}else {
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().
			print("<script>alert('회원가입 실패');location.href='./signupForm.do';</script>");
			return null;
		}
	}
	
}
