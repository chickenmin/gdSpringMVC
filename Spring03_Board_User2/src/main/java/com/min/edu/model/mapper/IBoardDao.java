package com.min.edu.model.mapper;

import java.util.List;

import com.min.edu.vo.BoardVo;

public interface IBoardDao {

//	게시판 리스트        userBoardlist
	public List<BoardVo> userboardlist();
	
	
//	게시글 삭제하기      delflagBoard
	public int delflagboard(List<String> seqs);
//	게시글 쓰기          writeboard
	public int writeboard(BoardVo vo);
	
//	게시글 상세보기      getoneboard
	public BoardVo getoneboard(String seq);
	
//	답글 업데이트       replyupdate
	public int replyupdate(BoardVo vo);
//	답글 입력           replyinsert
	public int replyinsert(BoardVo vo);
//	
//	삭제된 게시글 조회      restoreBoard
	public List<BoardVo> restoreboard();
//	게시글 복구             restoredelflag
	public int restoredelflag(List<String> seqs);
}
