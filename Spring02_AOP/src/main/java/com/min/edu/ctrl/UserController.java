package com.min.edu.ctrl;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.min.edu.dto.UserDto;
import com.min.edu.service.IUserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class UserController {

//	@Autowired
//	private IUserService service;
//	
//	@PostMapping(value = "/loginServlet.do")
//	public String userMain(Model model, @RequestParam Map<String, Object> map,HttpSession session ) {
//		UserDto loginDto = service.getLogin(map);
//		if (loginDto !=null) {
//			session.setAttribute("loginDto", loginDto);
//			session.setMaxInactiveInterval(10*60);
//			return "userMain";
//		}else {
//			return "redirect:/index.jsp";
//		}
//	}
//	@GetMapping
//	public String userMain(HttpSession session) {
//		session.invalidate();
//		return "redirect:/loginServlet.do";
//	}
	
	
}
