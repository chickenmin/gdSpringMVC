package com.min.edu.ctrl;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.min.edu.vo.RegistValidationDTO;

import lombok.extern.slf4j.Slf4j;

//TODO 074
@Slf4j
@Controller
public class FormValidatoinController {

	//TODO 075
	@GetMapping(value = "/formValidation.do")
	public String formValidation(){
		log.info("FormValidatoinController /formValidation.do 화면이동 ");
		return "formValidation";
		
	}
	
	//TODO 078
	@ModelAttribute("registValidationDto")	//jsp값과 같아야함
	public RegistValidationDTO modelAttribute() {
		RegistValidationDTO vo = new RegistValidationDTO();
		return vo;
	}
	
	//TODO 079
	@PostMapping(value = "/regist.do")
	public String regist(@ModelAttribute("registValidationDto") @Valid RegistValidationDTO dto,
								BindingResult result) {
		log.info("FormValidatoinController 회원가입 {}",dto);
		if (result.hasErrors()) {
			log.info("BindingResult 값 에러 발생");
			return "formValidation";
		}else {
			log.info("BindingResult 값 성공");
			return "redirect:/main.do";
		}
		
	}
}
