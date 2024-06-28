package com.min.edu.ctrl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.min.edu.dto.AnswerBoardDto;
import com.min.edu.dto.UserInfoDto;
import com.min.edu.service.IAnswerboardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BoardController {

	@Autowired
	private IAnswerboardService service;
	
	@GetMapping(value = "/boardList.do")
	public String boardList(Model model) {
		log.info("글 전체 조회");
		List<AnswerBoardDto> lists = service.selectAllBoard();
		model.addAttribute("lists", lists);
		return "boardList";
	}
	
	@PostMapping(value = "/multiDelete.do")
	public String multiDelete(@RequestParam List<String> ch) {
		log.info("다중 삭제 {}",ch);
		boolean isc = service.multiDeleteBoard(ch);
		
		if (isc) {
			return "redirect:/boardList.do";
		}else {
			return "error";
		}
		
	}
	
	@GetMapping(value = "/writeBoard.do")
	public String writeBoardForm() {
		return "insertBoardForm";
	}
	
	@PostMapping(value = "/writeBoard.do")
	public String writeBoard(AnswerBoardDto inDto, HttpServletRequest request) {
		HttpSession session = request.getSession();
		UserInfoDto loginDto = (UserInfoDto) session.getAttribute("loginDto");
		inDto.setId(loginDto.getId());
		boolean isc = service.insertBoard(inDto);
		
		if (isc) {
			return "redirect:/boardList.do";
		}else {
		return "redirect:/writeBoard.do";
		}
	}
	
	@GetMapping(value = "/detailBoard.do")
	public String detailBoard(String seq, Model model) {
		
		AnswerBoardDto dto = service.selectDetailBoard(seq);
		model.addAttribute("dto",dto);
		
		return "boardDetail";
	}
	
	@PostMapping(value = "/realDelete.do")
	public String realDelete(String seq, HttpServletRequest request) {
		HttpSession session = request.getSession();
		UserInfoDto loginDto = (UserInfoDto) session.getAttribute("loginDto");
		if (loginDto.getAuth().equalsIgnoreCase("A")) {
			boolean isc = service.deleteBoard(seq);
			if (isc) {
				return "redirect:/boardList.do";
			}else {
				return "error";
			}
		}else {
			return "redirect:/loginServlet.do";
		}
		
	}
	
	@GetMapping(value = "/modifyBoard.do")
	public String modifyForm(String seq,HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		UserInfoDto loginDto = (UserInfoDto) session.getAttribute("loginDto");
		 AnswerBoardDto dto = service.selectDetailBoard(seq);
		if (dto.getId().equals(loginDto.getId())) {
			model.addAttribute("dto",dto);
			return "modifyBoardForm";
		}else {
			return "redirect:/loginServlet.do";
		}
		 
	}
	
	
	
	@PostMapping(value = "/modifyBoard.do")
	public String modifyBoard(@RequestParam Map<String, Object> inMap, HttpServletRequest request) {
		HttpSession session = request.getSession();
		UserInfoDto dto = (UserInfoDto) session.getAttribute("loginDto");
		inMap.put("id",dto.getId() );
		boolean isc = service.modifyBoard(inMap);
		if (isc) {
			return "redirect:/detailBoard.do?seq="+inMap.get("seq");
		}else {
			return "redirect:/modifyBoard.do?seq="+inMap.get("seq");
		}
		
	}
	
	@GetMapping(value = "/replyBoard.do")
	public String replyForm(String seq, Model model) {
		AnswerBoardDto dto = service.selectDetailBoard(seq);
		model.addAttribute("dto", dto);
		return "replyBoardForm";
	}
	
	@PostMapping(value = "/replyBoard.do")
	public String reply(AnswerBoardDto inDto, HttpServletRequest request) {
		HttpSession session = request.getSession();
		UserInfoDto loginDto = (UserInfoDto)session.getAttribute("loginDto");
		inDto.setId(loginDto.getId());
		boolean isc = service.reply(inDto);
		if (isc) {
			return "redirect:/boardList.do";
		}else {
			return "redirect:/replyBoard.do?seq="+inDto.getSeq();
		}
	}
	
	
}





















