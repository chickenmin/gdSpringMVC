package com.min.edu.ctrl;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.min.edu.model.service.IUserService;
import com.min.edu.vo.UserVo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import oracle.jdbc.proxy.annotation.Post;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LoginController {

	private final IUserService service;
	
	@PostMapping(value = "/login.do")
	public String login(UserVo vo, //vo의 setter를 요청(jsp에서 파라미터 객체 객체로 받아올때)
						@RequestParam Map<String, Object>map, //map으로 받을때 name(key), value(value)
							String id, String password,	//개별로 받아올때 name과 같은 parameter에 형변환을 통해서
							HttpSession session, //scope
							Model model, //Spring Scope HttpServletrequest
							HttpServletRequest request //javax.servlet.* 객체
							) {
		
		log.info("@Controller LoginController login.do 요청받은 값 {}, {}",vo,map);
		UserVo loginVo = service.login(map);
		
		//일반 요청처리에서 Spring에서 
		//반환 타입이 문자열인 경우는 DispatcherServlet에 의해서 ViewResolver가 처리
		//반환타입에 redirect:문자열이 있는 경우는 DispatcherServlet이 다시 Controller 중에서 같은 이름의 매핑을 호출 //서블렛에선 주소를 찾는거엿음
		if (loginVo == null) {
			return "redirect:/main.do";
		}else {
	
		/*
		 * org.springframework.ui.Model은 Spring Container의 request 객체이다. @RequsetMapping 값을 공유
		 * 1) org.springframework.ui.Model model => model.addAttribute("loginVo", loginVo); => requestScope 처리
		 * 2) javax.servlet.httpServlet session => session.setAttribute("loginVo", loginVo); => sessionScope 처리
		 * 3) @SessionAttributes("loginVo") => model.addAttribute("loginVo", loginVo); => session + spring Container Session Scope 처리
		 */
			
//			request.setAttribute("loginVo", "request");
//			model.addAttribute("loginVo", "model");	//request, model 작성 순서 상관없이 model이 request보다 우선순위됨 , spring 객체가 우선
//			model.addAttribute("loginVo", "model2");	
//			session.setAttribute("loginVo", vo);
			
			model.addAttribute("loginVo", loginVo);	
			session.setAttribute("loginVo", loginVo);
			
		}
		return "afterLogin";
	}
}




















