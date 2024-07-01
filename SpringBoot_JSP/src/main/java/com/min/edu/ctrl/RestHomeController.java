package com.min.edu.ctrl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestHomeController {
	
	@GetMapping(value = "/rest")
	public List<String> rest(){
		return new ArrayList<String>();
	}

}
