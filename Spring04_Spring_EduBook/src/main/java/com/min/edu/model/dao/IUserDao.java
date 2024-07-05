package com.min.edu.model.dao;

import java.util.Map;

import com.min.edu.vo.UserVo;

//TODO 018
public interface IUserDao {
	
	//TODO 019
	public UserVo login(Map<String, Object> map);

}
