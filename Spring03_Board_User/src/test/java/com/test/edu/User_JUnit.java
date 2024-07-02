package com.test.edu;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.min.edu.model.mapper.IUserDao;
import com.min.edu.vo.UserVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class User_JUnit {

	@Autowired
	private IUserDao dao;
	
	
	@Test
	public void test() {
		UserVo loginvo = dao.getLogin(new HashMap<String, Object>(){{
			put("id","A001");
			put("password","A001");
		}});
		assertNotNull(loginvo);
		 int chk = dao.isDuplicateCheck("A001");
		 assertNotEquals(0, chk);
		 
		 UserVo signupVo = new UserVo();
		 signupVo.setEmail("rain2@gmail.com");
		 signupVo.setName("vivo");
		 signupVo.setPassword("rainbow");
		// int signupChk =  dao.signupMember(signupVo);
		// assertNotEquals(0, signupChk);
		
		List<UserVo> usersVo = dao.userSelectAll();
		assertNotEquals(0, usersVo.size()); 
	 	List<UserVo> searchUserVo = dao.getSearchUser(new HashMap<String, Object>(){{
			put("opt","id");
			put("keyword","코코볼");
		}});
	 	//assertNotEquals(0, searchUserVo.size());	// , name일땐 notnull
	 	assertEquals(0, searchUserVo.size());	//아이디일땐 null
	 	
	 	String id= dao.findId(new HashMap<String, Object>(){{
	 		put("name","비");
			put("email","rain@gmail.com");
	 	}});
	 	assertNotNull(id);
	}

}


























