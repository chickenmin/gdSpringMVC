package com.test.edu;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.min.edu.model.mapper.IBoardDao;
import com.min.edu.vo.BoardVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class Board_JUnitTest {

	@Autowired
	private IBoardDao dao;
	
	
	@Test
	public void board_test() {
	 List<BoardVo> boList =	dao.userboardlist();
	 assertNotEquals(0,boList.size()); 	//오류
	 
	 
	 
	 
//	 BoardVo writeVo = BoardVo.builder().id("A001").title("비옴").content("비와서 부대찌개").build();
//		int checkWrite =	 dao.writeboard(writeVo);
//	 	assertEquals(1, checkWrite);
		
//		int checkDal = dao.delflagboard(List.of("4","2","3"));
//		assertNotEquals(0, checkDal);

//		BoardVo checkBoard = dao.getoneboard("4");
//		assertNotNull(checkBoard);
		
//		List<BoardVo> restoreList = dao.restoreboard();
//		assertNotEquals(0, restoreList.size());
	
//		int restoreCheck = dao.restoredelflag(List.of("4","2","3"));
//		assertEquals(3, restoreCheck);
	}

}
