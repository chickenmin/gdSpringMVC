package com.min.edu.ctrl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.min.edu.model.service.IUserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserRestController {
	
	private final IUserService service;
	
	@PostMapping(value = "/duplicationAjax.do")
	public String duplicationAjax(String checkId) {
		int chk = service.isDuplicateCheck(checkId);
		Map<String, Object> map = new HashMap<String, Object>();
		String isc = (chk ==0)?"true":"false";
		map.put("isc", isc);
		Gson gson = new  GsonBuilder().create();
		String chJson = gson.toJson(map);
		return null;
	}

	
}
