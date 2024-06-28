package com.min.edu.model;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.edu.dto.UserDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class UserDaoImpl implements IUserDao {

	@Autowired
	private SqlSessionTemplate session;
	private final String NS = "com.min.edu.model.UserDaoImpl.";
	
	@Override
	public List<UserDto> getAllUserStatus() {
		log.info("전체 사용자 조회");
		return session.selectList(NS+"getAllUserStatus");
	}

	@Override
	public List<UserDto> getAllUser() {
		log.info("사용 가능한 사용자 조회");
		return session.selectList(NS+"getAllUser");
	}

	@Override
	public int updateAuthUser(Map<String, Object> map) {
		log.info("권한 수정: " + map);
		int n = session.update(NS+"updateAuthUser", map);
		
	
		return n;
	}

	@Override
	public int insertUser(UserDto dto) {
		log.info("사용자 입력: "+ dto);
		return session.insert(NS+"insertUser", dto);
	}

	@Override
	public UserDto getLogin(Map<String, Object> map) {
		log.info("로그인: " + map);
		return session.selectOne(NS+"getLogin", map);
	}

	@Override
	public UserDto getUserInfo(String seq) {
		log.info("사용자 상세정보: " + seq);
		return session.selectOne(NS+"getUserInfo", seq);
	}

	@Override
	public int updateUserInfo(Map<String, Object> map) {
		log.info("사용자 정보 수정: " + map);
		return session.update(NS+"updateUserInfo", map);
	}

	@Override
	public int delUser(String seq) {
		log.info("사용자 삭제: " + seq);
		return session.delete(NS+"delUser", seq);
	}

	@Override
	public String duplicateId(String id) {
		log.info("아이디 중복 체크: " + id);
		return session.selectOne(NS+"duplicateId", id);
	}

}
