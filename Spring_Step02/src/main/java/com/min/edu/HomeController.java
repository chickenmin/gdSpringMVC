package com.min.edu;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	@GetMapping(value = "/")
	public String hello(String name, Model model) {
		System.out.println("요청 받은 전달값 : "+name);
		model.addAttribute("value",name);
		
		
		return "/WEB-INF/views/hello.jsp";
	}
	
	@GetMapping(value = "/param") // http://localhost:8080/Spring_Step02/spring/param
	public String param(HttpServletRequest request, String name, int age, Model model) {
		//반환형을 void로 만들면 자동으로 메소드 이름으로 jsp가 만들어진다
		//파라미터 name은 없어도 자동으로  null로 되는데 int는 자동 형변환이 안됨 => 서버사이트 오류 500뜸
		System.out.println(name + 100);
		System.out.println(age+100);
		
		String reqName = request.getParameter("name");
		String reqAge = request.getParameter("age");
		
		System.out.println(reqName + 100);
		System.out.println(Integer.parseInt(reqAge)+100);
		
		model.addAttribute("info",name+"의 나이는? "+age);
		
		return "/WEB-INF/views/param.jsp";
	}

}















