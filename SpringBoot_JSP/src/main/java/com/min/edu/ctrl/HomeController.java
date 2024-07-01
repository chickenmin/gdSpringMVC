package com.min.edu.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	@GetMapping(value = "/")
	public String home(Model model) {
		model.addAttribute("homevalue", "home에서 전달 한 값");
		return "home";
	}
}
