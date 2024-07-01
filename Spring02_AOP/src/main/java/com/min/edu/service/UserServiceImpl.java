package com.min.edu.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.edu.dto.UserDto;
import com.min.edu.model.IUserDao;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private IUserDao dao;

	@Override
	public List<UserDto> getAllUserStatus() {
		return dao.getAllUser();
	}

	@Override
	public List<UserDto> getAllUser() {
		return dao.getAllUser();
	}

	@Override
	public int updateAuthUser(Map<String, Object> map) {
		return dao.updateAuthUser(map);
	}

	@Override
	public int insertUser(UserDto dto) {
		return dao.insertUser(dto);
	}

	@Override
	public UserDto getLogin(Map<String, Object> map) {
		return dao.getLogin(map);
	}

	@Override
	public UserDto getUserInfo(String seq) {
		return dao.getUserInfo(seq);
	}

	@Override
	public int updateUserInfo(Map<String, Object> map) {
		return dao.updateUserInfo(map);
	}

	@Override
	public int delUser(String seq) {
		return dao.delUser(seq);
	}

	@Override
	public String duplicateId(String id) {
		return dao.duplicateId(id);
	}

	
}
