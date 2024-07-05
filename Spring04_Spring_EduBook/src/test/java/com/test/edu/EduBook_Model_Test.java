package com.test.edu;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.min.edu.model.service.IUserService;
import com.min.edu.vo.UserVo;

//TODO 015
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/**/*.xml")	//빈 읽ㅇ서 생성햊는애
public class EduBook_Model_Test {

	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	@Autowired
	private IUserService service;
	
	@Before //before는 test없이 단독으로 안돈다
	public void test() {
		assertNotNull(sessionTemplate);
	}
	
	@Test
	public void login() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id","A001");
		map.put("password","A001");
		
		UserVo vo = sessionTemplate.selectOne("com.min.edu.model.mapper.UserDaoImpl.login", map);
		System.out.println(vo);
		assertNotNull(vo);
	}
	
	@Test
	public void ocp_login() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id","A001");
		map.put("password","A001");
		
		UserVo vo = service.login(map);
		assertNotNull(vo);
	}

}


















