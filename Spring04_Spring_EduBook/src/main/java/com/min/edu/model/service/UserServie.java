package com.min.edu.model.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.min.edu.model.dao.IUserDao;
import com.min.edu.vo.UserVo;

import lombok.RequiredArgsConstructor;

//TODO 017
@Service
@RequiredArgsConstructor
public class UserServie implements IUserService {

	
	private final IUserDao dao;
	
	//TODO 022
	@Override
	public UserVo login(Map<String, Object> map) {
		return dao.login(map);
	}
	
}
