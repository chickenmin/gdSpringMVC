package com.min.edu.ctrl;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.min.edu.model.service.IBoardService;
import com.min.edu.vo.BoardVo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class BoardController {
	
	private final IBoardService service;
	
	@GetMapping(value = "/home.do")
	public String home() {
		log.info("BoardController home.do GET 요청");
		return "home";
	}
	
	@GetMapping(value = "/boardList.do")
	public String boardList(Model model,HttpServletResponse response) {
		log.info("BoardController boardList.do GET 요청");
		
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Expires", "0");
		
		
		List<BoardVo> boardList= service.userboardlist();
		for (BoardVo vo : boardList) {
			String title = vo.getTitle();
			title = title.replaceAll("<", "&lt;");
			title = title.replaceAll("<", "&gt;");
			vo.setTitle(title);
			
			
			
			model.addAttribute("boardList",boardList);
		}
		
		return "boardList";
	}
	
	@PostMapping(value = "/multiDelete.do")
	public String multiDelete(@RequestParam List<String> chkVal,
							 @RequestParam("chkVal") String[] seqs,
							 @RequestParam Map<String, String> mapSeqs) {
		log.info("BoardController multiDelete.do 다중삭제 요청");
		
		log.info("List {}",chkVal);
		log.info("String[] {}", Arrays.toString(seqs));
		log.info("Map {}",mapSeqs);	//MAP은 이름이 같은 경우 하나만 가져옴
		
		int n= service.delflagboard(chkVal);
		log.info("다중삭제된 결과 {}",n);
		
		return "redirect:./boardList.do";
	}
}















