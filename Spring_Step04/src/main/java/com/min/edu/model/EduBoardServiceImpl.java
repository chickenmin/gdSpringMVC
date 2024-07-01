package com.min.edu.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.min.edu.dto.EduboardVo;

//TODO 019 @Service dao를 조합하여 실행시켜 줌, transaction을 처리하여 dao의 기능에 오류가 있다면 해당 메소드(빈)을 rollback시킨다
@Service
public class EduBoardServiceImpl implements IEduBoardService {

	@Autowired
	private IEduBoardDao dao;
	
	@Override
	public List<EduboardVo> selectBoard() {
		return dao.selectBoard();
	}

	@Override
	public int insertBoard(EduboardVo vo) {
		return dao.insertBoard(vo);
	}

	@Override
	public int updateBoard() {
		return dao.updateBoard();
	}

	//TODO 028 @Transactional(readOnly = true/false) Annotation에서 true 읽기 / false 삭제, 수정, 입력이 가능
	//					reaOnly true로 설정하여 Transaction이 동작되도록 설정
//						update 혹은 insert의 메소드가 오류가 발생했다면 해당 service의 모든 메소드를 Rollback
//						auto-proxy를 통해서 service가 제어 된다
	@Transactional(readOnly = true)
	@Override
	public int transaction(EduboardVo vo) {
		int n = dao.updateBoard();
		int m = dao.insertBoard(vo);
		return (n>0 || m>0)?1:0;
	}

}





















