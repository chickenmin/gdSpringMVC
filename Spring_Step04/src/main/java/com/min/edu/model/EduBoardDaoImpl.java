package com.min.edu.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.edu.dto.EduboardVo;

import lombok.extern.slf4j.Slf4j;

//TODO 018 @Repository: Database와 java의 연동을 통해서 쿼리실행, 결과를 담는 클래스 DAO(Data Access Object)
@Slf4j
@Repository
public class EduBoardDaoImpl implements IEduBoardDao {
	//namespace - property로 만드는게 좋음
	
	
	//주입방법 1 생성자 통한 주입 2.세터 매소드 3.일반 메소드주입 4 멤버필드주입 => 생성자랑 멤버필드 주입방법 주로 사용
	
	//멤버필드 주입방법
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String NS = "com.min.edu.model.EduBoardDaoImpl.";
	
	@Override
	public List<EduboardVo> selectBoard() {
		log.info("Eduboard 전체 조회");
		return sqlSession.selectList(NS+"selectBoard");
	}

	@Override
	public int insertBoard(EduboardVo vo) {
		log.info("Eduboard 새글 입력");
		return sqlSession.insert(NS+"insertBoard", vo);
	}

	@Override
	public int updateBoard() {
		log.info("Eduboard 모든글 delflag y변경");
		return sqlSession.update(NS+"updateBoard");
	}
	
}
