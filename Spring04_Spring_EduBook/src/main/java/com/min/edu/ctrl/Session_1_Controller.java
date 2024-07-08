package com.min.edu.ctrl;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import lombok.extern.slf4j.Slf4j;

//TODO 029
@Slf4j
@Controller
@SessionAttributes("sessionTest")
public class Session_1_Controller {
	
	//TODO 030
	@GetMapping(value = "/sessionInit.do")
	public String sessionInit(Model model, HttpSession session) {
		log.info("Session_1_Controller sessionInit.do : HttpSession 및 @sessionAttributes 테스트 값을 입력");
		log.info("HttpSession의 httpSessionTest / @sessionAttributes의 sessionTest");
		
		session.setAttribute("httpSessionTest", "sessionInit.do 입력된 HttpSession 값");
		model.addAttribute("sessionTest", "sessionInit.do 입력된 @sessionAttributes 값");
		
		return "sessionCheck";
	}
	
	//TODO 033
	@GetMapping(value = "/test01.do")
	public String test01(SessionStatus sessionStatus) {
		log.info("Session_1_Controller /test01.do : @SessionAttributes는 setComplete()를 통해서 삭제");
		sessionStatus.setComplete();	//해당컨트롤러에서 사용하고 있는 모든 attribute를 삭제
		return "sessionCheck";
		
	}
	
	
	//TODO 035
	@GetMapping(value = "/result01.do")
	public String result01(HttpSession session, 
							@SessionAttribute(value = "sessionTest", required = false) String sessionTest) { //session값 받아와서 캐스팅따로 해야하는 수고를 덜 수 있다
		log.info("HttpSession과 @SessionAttribute출력");
		System.out.println("==============="+session.getAttribute("httpSessionTest"));
		System.out.println("==============="+sessionTest);
		return "sessionCheck";
	}
	
	//TODO 037
	@GetMapping(value = "/test02.do")
	public String test02(HttpSession session,
				@SessionAttribute(value = "sessionTest", required = false) String sessionTest) {
		log.info("Session_1_Controller /test02.do   HttpSession remove() & invalidate로 삭제");
		session.invalidate();	//spring bean으로 만들어진 @SessionAttributes("sessionTest")는 spring의 session값은 javax의 HttpSession 메소드로 삭제가 안됨
//		session.removeAttribute("httpSessionTest");
//		System.out.println("---------------"+session.getAttribute("httpSessionTest")); //세션이 무효화 되었습니다.
//		session.removeAttribute("sessionTest");	
		System.out.println("---------------"+sessionTest); 
		
		return "sessionCheck";
//		동일한 메소드 내에서 session을 invalidate한 후, session.getAttribute("httpSessionTest"))하면 세션이 무효화되었다고 오류 뜸
//		다른 메소드에서(예_Session_2_Controller / test04) 아규먼트로 만료된 session을 받을 경우는 null로 전달됨
	}
	
}













