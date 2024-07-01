package com.min.edu.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.min.edu.dto.EduboardVo;
import com.min.edu.model.IEduBoardService;

import lombok.extern.slf4j.Slf4j;

//TODO 029 Transaction 처리를 위한 Controller Bean
@Slf4j
@Controller
public class TransactionController {
	
	@Autowired
	private IEduBoardService service;
	
	@PostMapping(value = "/transaction.do")
	public String transaction(EduboardVo inVo) {
		log.info("TransactionController Transaction처리를 위한 post : {}",inVo);
		service.transaction(inVo);
		return "redirect:/selectBoard.do";
	}

}
