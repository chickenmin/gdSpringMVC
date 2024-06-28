package com.min.edu.service;

import java.util.List;
import java.util.Map;

import com.min.edu.dto.UserDto;

public interface IUserService {

	public List<UserDto> getAllUserStatus();

	public List<UserDto> getAllUser();

	public int updateAuthUser(Map<String, Object> map);

	public int insertUser(UserDto dto);

	public UserDto getLogin(Map<String, Object> map);

	public UserDto getUserInfo(String seq);

	public int updateUserInfo(Map<String, Object> map);

	public int delUser(String seq);

	public String duplicateId(String id);
}
