package com.min.edu.model.service;

import java.util.List;

import com.min.edu.vo.BoardVo;

public interface IBoardService {
//	게시판 리스트        userBoardlist
	public List<BoardVo> userboardlist();
	
	
//	게시글 삭제하기      delflagBoard
	public int delflagboard(List<String> chkVal);
//	게시글 쓰기          writeboard
	public int writeboard(BoardVo vo);
	
//	게시글 상세보기      getoneboard
	public BoardVo getoneboard(String seq);
	
	//reply답글 작성 transaction
	public int reply(BoardVo vo);
//	
//	삭제된 게시글 조회      restoreBoard
	public List<BoardVo> restoreboard();
//	게시글 복구             restoredelflag
	public int restoredelflag(List<String> seqs);


}
