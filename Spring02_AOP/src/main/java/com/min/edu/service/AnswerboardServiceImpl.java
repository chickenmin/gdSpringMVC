package com.min.edu.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.min.edu.dto.AnswerBoardDto;
import com.min.edu.dto.UserInfoDto;
import com.min.edu.model.IAnswerBoardDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AnswerboardServiceImpl implements IAnswerboardService {

	@Autowired
	private IAnswerBoardDao dao;
	
	@Override
	public List<AnswerBoardDto> selectAllBoard() {
		log.info("전체글 보기");
		return dao.selectAllBoard();
	}

	@Override
	public AnswerBoardDto selectDetailBoard(String seq) {
		log.info("상세글 보기");
		return dao.selectDetailBoard(seq);
	}

	@Override
	public boolean modifyBoard(Map<String, Object> map) {
		log.info("글 수정");
		return dao.modifyBoard(map);
	}

	@Override
	public boolean multiDeleteBoard(List<String> list) {
		log.info("다중 삭제");
		return dao.multiDeleteBoard(list);
	}

	@Override
	public boolean insertBoard(AnswerBoardDto dto) {
		log.info("새글 입력");
		return dao.insertBoard(dto);
	}

	@Override
	public boolean deleteBoard(String seq) {
		log.info("db삭제");
		return dao.deleteBoard(seq);
	}

	@Override
	@Transactional
	public boolean reply(AnswerBoardDto dto) {
		log.info("답글 업데이트 및 입략");
		int n = dao.replyUpdate(dto);
		int m = dao.replyInsert(dto);
		return (n+m)>0?true:false;
	}

	

}
