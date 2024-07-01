package com.min.edu.service;

import java.util.List;
import java.util.Map;

import com.min.edu.dto.AnswerBoardDto;

public interface IAnswerboardService {
//	전체글 조회       selectAllBoard
	public List<AnswerBoardDto> selectAllBoard();
	
//	상세글 조회       selectDetailBoard
	public AnswerBoardDto selectDetailBoard(String seq);
	
//	글 수정           modifyBoard
	public boolean modifyBoard(Map<String, Object> map);
	
//	다중 글 삭제          multiDeleteBoard
	public boolean multiDeleteBoard(List<String> list);
	
//	글 입력           insertBoard
	public boolean insertBoard(AnswerBoardDto dto);
	
//	DB 글 삭제        deleteBoard
	public boolean deleteBoard(String seq);
	
	//답글 작성 reply
	public boolean reply(AnswerBoardDto dto);
	
}
