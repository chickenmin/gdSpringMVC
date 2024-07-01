package com.min.edu.model;

import java.util.List;

import com.min.edu.dto.EduboardVo;

//TODO 017 DAO의 각 Unit기능을 정의하는 인터페이스
public interface IEduBoardDao {

	public List<EduboardVo> selectBoard();
	
	public int insertBoard(EduboardVo vo);
	
	public int updateBoard();
	
}
