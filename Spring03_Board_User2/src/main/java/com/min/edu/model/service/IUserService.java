package com.min.edu.model.service;

import java.util.List;
import java.util.Map;

import com.min.edu.vo.UserVo;

public interface IUserService {


	/**
	 * 로그인
	 * @param map id password
	 * @return null 혹은 UserVo 객체
	 */
	public UserVo getLogin(Map<String, Object> map);
	
/**
 * 	isDuplicateCheck        
 * @param id String
 * @return 0 혹은 1
 */
	public int isDuplicateCheck(String id);
	
	
/**
 * 	signupMember            회원가입
 * @param vo UserVo
 * @return 0 혹은 1
 */
	public int signupMember(UserVo vo);
	
/**
 * 	userSelectAll           회원전체조회
 * @return  List<UserVo>
 */
	public List<UserVo> userSelectAll();
	
/**
 * 	getSearchUser           회원검색
 * @param map opt keyword
 * @return List<UserVo>
 */
	public List<UserVo> getSearchUser(Map<String, Object> map);
	
/**
 * 	findId                  아이디 찾기
 * @param map name email
 * @return null 혹은 String
 */
	public String findId(Map<String, Object> map);
	
	
	
}
