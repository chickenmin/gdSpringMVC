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
		log.info("UserRestController duplicationAjax 아이디 중복검사");
		int check= service.isDuplicateCheck(checkId);
		
		Map<String, Object> map = new HashMap<String, Object>();
		String chk = check == 0 ? "true":"false";
		map.put("isc", chk);
		
		Gson gson = new GsonBuilder().create();
		String chkJson = gson.toJson(map);
		log.info("완료된 판단 결과의 json String : {}",chkJson);
		return chkJson;
	}
	
	@PostMapping(value = "/duplicationFetch.do")
	public String duplicationFetch(@RequestBody String checkId) {
		log.info("UserRestController duplicationFetch.do 아이디 중복검사");
		log.info("Fetch에서 전달받은 요청 값 {}",checkId);
		int check= service.isDuplicateCheck(checkId);
		
		return (check ==0) ? "true":"false";
	}
}
