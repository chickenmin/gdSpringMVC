package com.min.edu.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.edu.dto.AnswerBoardDto;

import lombok.extern.slf4j.Slf4j;

// Slf4j에서 사용하는 변수가 log
@Slf4j
@Repository
public class AnswerBoardDaoImpl implements IAnswerBoardDao {

	@Autowired
	private SqlSessionTemplate session;
	
	private final String NS = "com.min.edu.model.AnswerBoardDaoImpl.";
	
	@Override
	public List<AnswerBoardDto> selectAllBoard() {
		return session.selectList(NS+"selectAllBoard");
	}

	@Override
	public AnswerBoardDto selectDetailBoard(String seq) {
		return session.selectOne(NS+"selectDetailBoard", seq);
	}

	@Override
	public boolean modifyBoard(Map<String, Object> map) {
		int n = session.update(NS+"modifyBoard", map);
		return (n==1)?true:false;
	}

	@Override
	public boolean multiDeleteBoard(List<String> list) {
		int n = session.delete(NS+"multiDeleteBoard", list);
		return (n>0)?true:false;
	}

	@Override
	public boolean insertBoard(AnswerBoardDto dto) {
		int n = session.insert(NS+"insertBoard", dto);
		return (n==1)?true:false;
	}

	@Override
	public boolean deleteBoard(String seq) {
		int n = session.delete(NS+"deleteBoard", seq);
		return (n==1)?true:false;
	}

	// Spring 때 Bean 으로 만들어서 사용
	@Override
	public int replyUpdate(AnswerBoardDto dto) {
		int n = session.update(NS+"replyUpdate", dto);
		return n;
	}

	// Spring 때 Bean 으로 만들어서 사용
	@Override
	public int replyInsert(AnswerBoardDto dto) {
		int n = session.insert(NS+"replyInsert", dto);
		return n;
	}



}
