package com.min.edu.ctrl;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.min.edu.vo.UserVo;

import lombok.extern.slf4j.Slf4j;

//<!--TODO 048  -->
@Slf4j
@Controller
public class ModelAttributeController {
	
	//TODO 049
	@ModelAttribute("userId")
	public String getUserId(HttpSession session) {
		UserVo loginVo = (UserVo) session.getAttribute("loginVo");
		log.info("ModelAttributeController 로그인된 세션에서 id만을 추출 {}",loginVo.getId());
		
		return loginVo.getId();
	}
	
	//TODO 050
	@GetMapping(value = "/modelAttribute.do")
	public String modelA(@ModelAttribute("userId") String id,
						Model model) {
		log.info("ModelAttributeController /modelAttribute.do  @ModelAttribute");
		model.addAttribute("id", id);
		return "modelA";
	}
	
}
