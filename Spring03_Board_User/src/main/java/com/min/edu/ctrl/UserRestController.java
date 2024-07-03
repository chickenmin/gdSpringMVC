package com.min.edu.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.util.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.ognl.MemberAccess;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.min.edu.model.service.IUserService;
import com.min.edu.vo.UserVo;

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
		String chk = (check == 0) ? "true":"false";
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
	 
	@PostMapping(value = "/findId.do")
	public String findId(@RequestParam Map<String, Object> map) {
		log.info("UserRestController findId 아이디 찾기");
		log.info("전달받은 요청값 : {}",map);
		String id = service.findId(map);
		return StringUtils.defaultIfEmpty(id, "");
	}

//	@PostMapping(value = "/convertForm.do")
//	public String convertForm(@RequestBody List<Map<String, String>> data) {
//		
//		for (Map<String, String> map : data) {
//			String fieldName = map.get("name");
//			String fieldValue = map.get("value");
//			System.out.printf("%s / %s",fieldName,fieldValue);
//		}
//		return "check";
//	}
	
	@PostMapping(value = {"/{toAuth}.do","/{toUser}.do"})
	public String convertForm(@RequestParam List<String> chkid, 
								@PathVariable(value = "toAuth",required = false) String toAuth,
								@PathVariable(value = "toUser", required = false) String toUser) {
		System.out.println(chkid);
		
		System.out.println(toAuth);
		System.out.println(toUser);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("checkid", chkid);
		map.put("authValue", toAuth.equals("toAuth")?"A":"U");
		int n = service.setChangeAuth(map);
		
		return (n>0)? "true":"false";
	}

	@SuppressWarnings("unchecked")
	@PostMapping(value = "/getSearchUser.do")
	public String getSearchUser(@RequestParam Map<String, Object> map) {
		log.info("UserRestController getSearchUser 회원상세조회{}",map);
		List<UserVo> searchList = service.getSearchUser(map);
		
		/*
		 * 	{"연필":"모나미"} - JSON Object
		 *  {"문방사우":[{"연필":"모나미"},{"지우개":"모닝글로리"}]}	 - JSON Array
		 */
//		1) JSON Object 작성방법
		JSONObject obj = new JSONObject();
		obj.put("연필", "모나미");
		System.out.println(obj.toJSONString());
		
//		2)JSON Array 작성방법
		JSONArray jArray = new JSONArray();
		JSONObject jObj1 = new JSONObject();
		jObj1.put("연필", "모나미");
		JSONObject jObj2 = new JSONObject();
		jObj2.put("지우개", "모닝글로리");
		jArray.add(jObj1);
		jArray.add(jObj2);
		
		JSONObject totalObj =  new JSONObject();
		totalObj.put("문방사우", jArray);
		System.out.println(totalObj.toJSONString());
		
		//GSON
		Gson gson = new GsonBuilder().create();
		
		return gson.toJson(searchList);
	}


}



























