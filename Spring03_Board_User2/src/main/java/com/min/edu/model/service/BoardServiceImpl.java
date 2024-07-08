package com.min.edu.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.min.edu.model.mapper.IBoardDao;
import com.min.edu.vo.BoardVo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class BoardServiceImpl implements IBoardService {
	
	private final IBoardDao dao;

	@Override
	public List<BoardVo> userboardlist() {
		log.info("BoardServiceImpl {}", "userboardlist");
		return dao.userboardlist();
	}

	@Override
	public int delflagboard(List<String> seqs) {
		log.info("BoardServiceImpl {}", "delflagboard");
		return dao.delflagboard(seqs);
	}

	@Override
	public int writeboard(BoardVo vo) {
		log.info("BoardServiceImpl {}", "");
		return dao.writeboard(vo);
	}

	@Override
	public BoardVo getoneboard(String seq) {
		log.info("BoardServiceImpl {}", "");
		return dao.getoneboard(seq);
	}

	@Override
	public int reply(BoardVo vo) {
		log.info("BoardServiceImpl {}", "reply");
		int n = dao.replyupdate(vo);
		int m = dao.replyinsert(vo);
		
		return (n+m)>0?1:0;
		}

	@Override
	public List<BoardVo> restoreboard() {
		log.info("BoardServiceImpl {}", "restoreboard");
		return dao.restoreboard();
	}

	@Override
	public int restoredelflag(List<String> seqs) {
		log.info("BoardServiceImpl {}", "restoredelflag");
		return dao.restoredelflag(seqs);
	}

	
	
}
