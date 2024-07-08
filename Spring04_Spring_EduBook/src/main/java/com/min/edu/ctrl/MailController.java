package com.min.edu.ctrl;

import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

//TODO 054
@Slf4j
@Controller
public class MailController {
	
	@Autowired
	private JavaMailSender mailSender;

	//TODO 055
	@GetMapping(value = "/mailform.do")
	public String mailForm() {
		log.info("MailController mailForm 메일 작성 화면");
		return "mailForm";
	}
	
	//TODO 059
	@PostMapping(value = "/mailSender.do")
	public String mailSender(@RequestParam Map<String, String> mailMap) {
		log.info("MailController mailSender.do요청값 : {}",mailMap);
		//자신의 메일주소가 필수적으로 입력되어야한다
		String setFrom = "kkjm1021@naver.com";
		
		//메일 내용을 전송하기 위한 객체  MimeMessage
		MimeMessage message = mailSender.createMimeMessage();
		
		//MimeMessageHelper : MimeMessage(송신서버정보), false(파일첨부여부), UTF-8(글자인코딩)
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true,"UTF-8");
			helper.setFrom(setFrom);
			helper.setTo(mailMap.get("email"));
			helper.setSubject(mailMap.get("title"));	//생략 가능
			helper.setEncodeFilenames(true);
			
			//내용처리(text,HTML)
			//true : 글자를 html인식, false: text로 인식
			helper.setText(mailMap.get("content"),true);
			
			//첨부파일 처리
			FileSystemResource fileSystemResource = new FileSystemResource("C:\\Users\\GDJ\\Downloads\\004001.png");
			helper.addAttachment("포켓몬.png", fileSystemResource);
			
			mailSender.send(message);
			
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return "redirect:/mailform.do";
	}
}















