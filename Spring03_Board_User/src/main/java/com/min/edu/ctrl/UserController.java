package com.min.edu.ctrl;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping(value = "/findIdWindow.do")
	public String findIdWindow() {
		log.info("UserController findIdWindow.do 아이디 찾기 이동");
		return "findId";
	}
	
	@PostMapping(value = "/login.do")
	public String login(@RequestParam Map<String, Object>map, HttpSession session, HttpServletResponse response) throws IOException {
		log.info("UserController /login.do 로그인 이동");
		response.setContentType("text/html; charset=UTF-8;");
		//헤더정보 : 보내는 값이 들어있고 인코딩-마메타입
		UserVo loginVo = service.getLogin(map);
		
		if (loginVo !=null) {
			session.setAttribute("loginVo", loginVo);
			session.setMaxInactiveInterval(60*10*5);
			response.getWriter().print("<script>alert('"+ loginVo.getName()+"님 반갑습니다');location.href='./boardList.do';</script>");
		}else {
			response.getWriter().print("<script>alert('로그인 정보가 없습니다');location.href='./loginForm.do';</script>");
		}
		
		
		return null;
	}
	
	@GetMapping(value = " ./logout.do")
	public String logout(HttpSession session, HttpServletResponse response) {
		log.info("UserController /logout.do 로그아웃 이동");
		//로그아웃을 해도 뒤로가기 하면 캐시정보가 남아있는데 그 캐시정보 없애기
		//https://velog.io/@cham/HTTP-Header%EC%97%90%EB%8A%94-%EC%96%B4%EB%96%A4-%EC%A0%95%EB%B3%B4%EB%93%A4%EC%9D%B4-%EB%8B%B4%EA%B2%A8%EC%9E%88%EC%9D%84%EA%B9%8C

		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Expires", "0");
		
		
		session.invalidate();
		return "redirect: ./loginForm.do";
	}
	
	
	
	@GetMapping(value = "/managementUser.do")
	public String managementUser(Model model) {
		log.info("UserController /managementUser.do 회원관리 이동");
		List<UserVo> userList = service.getAllUser();
		model.addAttribute("userList", userList);
		return "managementUser";
	}
	
	
	@GetMapping(value = "/userSelectAll.do")
	public String userSelectAll(Model model) {
		log.info("UserController /userSelectAll.do [관리자] 회원전체조회 이동");
		List<UserVo> userList = service.userSelectAll();
		model.addAttribute("userList", userList);
		return "userSelectAll";
	}
}

























