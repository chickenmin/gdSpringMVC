package com.min.edu.ctrl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;






/**
 * 
 * @Controller란?
 *  - stereotype Bean으로 spring container가 자동으로 등록하여 가지고 있는 객체
 *  - Bean을 만드는 방법 1)spring bean configuration(xml)을 통해서 DispatcherServlet이 생성
 *  				  2)class 위에 Annotation(@Component, @Controller, @Service, @Repository)을 통해서 생성
 *  - 1)방법 프로세스 : web.xml -> <servlet> -> servlet-context.xml -> <bean> 자동으로 등록
 *    2)방법 프로세스 : servlet-context.xml - > <context:component-scan base-package="top-level하위 모든것"> -> <bean>등록
 *    
 *  @RequestMapping, @GetMapping, @PostMapping...란?  
 *  - 요청되는 주소에서 실행하고자 하는 메소드를 찾는다(Handler-Mapping) 컼트롤러찾아주는애
 *  @RequestMapping(value="/매핑명",method={RequestMethod.프로토콜})
 *  - Spring framework 4.3.25 버전이상 부터는 @GetMapping과 @PostMapping 등을 사용할 수 있다
 *  
 *  처리 프로세스 : 
 *  요청되는 주소(String)에서 Handle-Adapter에 의해서 해당 메소드를 찾아서 실행
 *  요청값(Param) HttpServletRequest는 자동으로 자바의 객체와 매핑(타입,변수명)
 *  이름이 없고 값도 없는애 - > null
 *  이름이 있고 값은 없는애 => ""- >get으로 넘어갈 경우 500뜸
 *  	- 용어 : 바인딩 (binding) 완벽하지 않은 문장 빈곳에 값을 넣어서 완벽하게 만드는 것
 *  		      파서 (parse) 값을 다른 형태로 변환
 *  
 *  화면에서의 흐름제어(forward, redirect)
 *  -forward는 다음의 html을 구성하는 jsp에 값(객체)를 가져갈때 사용 (값을 전달할 수 있삼.HttpServletRequest)
 *  -redirect는 페이지를 요청할때 사용 (새로운 페이지를 생성하기때문에 값을 전달할 수 없다)
 *  Spring에서의 흐름제어 
 *  -DispatcherServlet에서 처리가 됨, org.springframework.ui.Model이 값을 담는 객체가 됨
 *  -InternalResourceViewResolver에 의해서 화면으로 이동
 *   => ModelAndView(MAV) _요즘안쓰는 방식
 *   
 *   	@GetMapping("/info.do")
 *   	public ModelAndView info(){
 *   		ModelAndView mav = new ModelAndView();
 *   		mav.setViewName("info");
 *   		mav.addObject("name","안녕하세요")
 *   		return mav;
		}
		
	-Spring framework은 DispatcherServlet이 처리해주면
	Model 객체는 값 + ViewResolver는 이동화면 <= ModelAndView
*
*	-요청되는 메소드가 반환되는 String은 DispatcherServlet에 의해서 ViewResolver처리하여
* 	prefix + String + suffix를 생성하면 해당 페이지를 요청
* 
*  -Spring Redirect는 ws(browser)의 주소에 요청하는 것이 아니라 매핑이름을 다시 탐색
*  
*  
*  
*  전송되는 Scope의 처리
*  Model은 request scope로 동작한다
*   따라서 session, application scope사용하기 위해서는 servlet에서 사용햇던 방식으로 사용
*   
*   //서블렛 방식
*   public String login(HttpServletRequest req){
*   	HttpSession session = req.getSession();
*   	session.setAttribute("loginDto",loginDto);
*   }
*   
*   //스프링 방식
*   public String login(HttpSession session){
*   	session.setAttribute("loginDto",loginDto);
*   }
 */
@Slf4j
@Controller
public class HomeController {

		// @ GETMapping 말고 이렇게 사용하는 회사도 있음
//		@RequestMapping(value = "/home.do",method = {RequestMethod.GET, RequestMethod.POST})	//get과 post 요청 모두 한번에 가용함
//		public String home(String name, Model model) {
//			log.info("HomeController /home.do GET");
//			log.info("전달받은 요청값 : {}" , name);
//			model.addAttribute("name", name+"님 반값습니다");
//			return "home";
//		}
	
	
	/*
	 * TODO 001 home.do 호출된 @GetMapping은 get 요청만을 처리한다
	 * 			화면에서 요청받은 값은 자동으로 해당 타입으로 변환, 화면의 NAME 값과 변수의 명이 같아야함 => JSP에서 NAME의 이름이 메소드에서 받는 아규먼트명과 같아야함
	 * */
	//메소드를 먼저 만들고 getMapping annotation을 사용해야함
	@GetMapping(value = "/home.do")
	public String home(String name, Model model,HttpServletRequest request) {
		log.info("@GetMapping home.do 요청, 요청값{}",name);
		
		//spring의 model객체는 request scope이다
		model.addAttribute("model_str",name+"바보");
		request.setAttribute("req_str",name+"바보");
		
		//만약에 반환이 없거나 NULL이라면 DispathcerServlet은 메소드명과 같은 값을 전달
		return null;
	}
	
	//TODO 002 home.do 호출, @PostMapping는 post만 처리한다
	@PostMapping(value = "/home.do")
	public String home(String name, Model model) {
		log.info("@PostMapping home 요청, 요청받은 값{}",name);
		
		/*
		 * 1)null이라면 method명을 반환
		 * 2)문자열 반환
		 * 3) 반환되는 문자열은 DispatcherServlet에 의해서 ViewResolver를 통해서
		 * 		prefix + 문자열 + suffix로 만들어진 후 해당 위치의 페이지를 호출
		 * 		만약 ViewResolver를 사용하지 않는다면 "/WEB-INF/views/home.jsp"로 작성해주면 된다
		 * */
		return "home";
	}
	//TODO 003 @RequestMapping Annotation 을 통해서 get.post요청을 다중으로 처리
	@RequestMapping(value = "/info.do",method = {RequestMethod.GET, RequestMethod.POST})
	public void info() {
		log.info(" @RequestMapping을 통한 GET/POST");
	}
	
	//TODO 004 Spring에서의 redirect는 자신의 Application에서 Mapping을 탐색하여 호출
	
	@GetMapping(value = "/redirect.do")
	public String redirect(String name) {
		log.info("@GetMapping /redirect.do, 요청받은 값{}",name);
		
		//redirect는 get방식 호출(post호출 불가) , mapping value를 탐색하여 해당  value를 실행
		return "redirect:/home.do?name="+name+"_redirect";
	}
	
	
}











