package com.min.edu.ctrl;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.support.SessionStatus;

import lombok.extern.slf4j.Slf4j;

//TODO 038 다른 컨트롤러에서 HttpSession과 @SessionAttributes 사용과 삭제
@Slf4j
@Controller
public class Session_2_Controller {
	
	//TODO 040
	@GetMapping(value = "/test03.do")
	public String test03(SessionStatus sessionStatus
							,HttpSession session, 
							@SessionAttribute(value = "sessionTest", required = false) String sessionTest) {
		log.info("다른 컨트롤러에서 @SessionAttribute를 사용할 수 있다 {}",sessionTest);
		log.info("다른 컨트롤러에서 SessionStatus를 통해서 @SessionAttribute를 삭제할 수 있을가?");
		sessionStatus.setComplete();
		return "sessionCheck";
	}
	
	//TODO 041
	@GetMapping(value = "/result03.do")
	public String result03(HttpSession session,
							@SessionAttribute(value = "sessionTest", required = false) String sessionTest) {
		log.info("HttpSession과 @SessionAttribute를 출력 \n 다른 컨트롤러에서는 sessionStatus.setComplete() 동작안함");
		System.out.println("------------------"+session.getAttribute("httpSessionTest"));
		System.out.println("------------------"+sessionTest);
		return "sessionCheck";
	}
	
	//TODO 044
	@GetMapping(value = "/test04.do")
	public String test04(HttpSession session) {
		log.info("HttpSession의 invalidate");
		session.invalidate();
		return "sessionCheck";
	}
	
	//TODO 046
	@GetMapping(value = "/result04.do")
	public String result04(HttpSession session,
							@SessionAttribute(value = "sessionTest", required = false) String sessionTest) {
		log.info("HttpSession 출력 : {}",session.getAttribute("httpSessionTest"));
		log.info("@SessionAttribute 출력 : {}",sessionTest);
		return "sessionCheck";
	}
}

























