package com.min.edu.model.mapper;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.min.edu.vo.BoardVo;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BoardDaoImpl implements IBoardDao {

	private final SqlSessionTemplate session;
	private final String NS = "com.min.edu.model.mapper.BoardDaoImpl.";
	
	@Override
	public List<BoardVo> userboardlist() {
		return session.selectList(NS+"userboardlist");
	}

	@Override
	public int delflagboard(List<String> seqs) {
		
		return session.update(NS+"delflagboard", seqs);
	}

	@Override
	public int writeboard(BoardVo vo) {
		
		return session.insert(NS+"writeboard", vo);
	}

	@Override
	public BoardVo getoneboard(String seq) {
		
		return session.selectOne(NS+"getoneboard", seq);
	}

	@Override
	public int replyupdate(BoardVo vo) {
		
		return session.update(NS+"replyupdate", vo);
	}

	@Override
	public int replyinsert(BoardVo vo) {
		
		return session.insert(NS+"replyinsert", vo);
	}

	@Override
	public List<BoardVo> restoreboard() {
		
		return session.selectList(NS+"restoreboard");
	}

	@Override
	public int restoredelflag(List<String> seqs) {
		
		return session.update(NS+"restoredelflag", seqs);
	}

}
