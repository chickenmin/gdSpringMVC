package com.min.edu.model.dao;

import java.util.Map;

import javax.websocket.Session;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.edu.vo.UserVo;

//TODO019
@Repository
public class UserDaoImpl implements IUserDao {

	@Autowired
	private SqlSessionTemplate template;
	
	//TODO 020
	@Override
	public UserVo login(Map<String, Object> map) {
		return template.selectOne("com.min.edu.model.mapper.UserDaoImpl.login", map);
	}
}
