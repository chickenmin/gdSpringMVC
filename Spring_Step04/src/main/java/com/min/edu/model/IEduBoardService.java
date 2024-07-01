package com.min.edu.model;

import java.util.List;

import com.min.edu.dto.EduboardVo;

//TODO 016 Dao를 조합 및 관리하기 위한 클래스의 Interface
public interface IEduBoardService {
	//생성은 서비스부터 구현은 다오부터
	
	public List<EduboardVo> selectBoard();
	
	public int insertBoard(EduboardVo vo);
	
	public int updateBoard();
	
	//TODO 027 DAO의 update와 insert를 실행시키는 service 메소드
	public int transaction(EduboardVo vo);
}
