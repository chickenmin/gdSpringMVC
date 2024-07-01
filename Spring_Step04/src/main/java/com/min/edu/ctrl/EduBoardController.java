package com.min.edu.ctrl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.min.edu.dto.EduboardVo;
import com.min.edu.model.IEduBoardService;

import lombok.extern.slf4j.Slf4j;
import oracle.jdbc.proxy.annotation.Post;

@Slf4j
@Controller
public class EduBoardController {

	@Autowired
	private IEduBoardService service;
	
	@Value("${server.name}")
	private String projectName;
	
	//TODO 020 GET 방식으로 호출하여 MVC모델을 VMI하여 호출된다
	//			<context:property-placeholder>를 통해서 생성된 bean은 @value를 어디서든지 통해서 사용할 수 잇다
	@GetMapping(value = "/selectBoard.do")
	public String selectBoard(Model model) {
		log.info("Properties파일에서 읽은 값 : {}",projectName);
		List<EduboardVo> lists=  service.selectBoard();
		model.addAttribute("lists",lists);
		return "boardList";
	}
	//TODO 021 POST방식으로 호출
	//	spring 자동으로 연결된 DTO/VO객체의 SETTER를 호출하여 객체를 만들어 준다.
	@PostMapping(value = "/insertBoardVo.do")
	public String insertBoard(EduboardVo invo) {
		log.info("페이지의 name을 입력받을 수 있는 setter함수를 가는 dto/vo : {}",invo);
		int n = service.insertBoard(invo);
		if (n ==1) {
			return "redirect:/selectBoard.do";
		}else {
			return "";
		}
		
	}
	
	//TODO 022 java.util.Map의 형태로 파라미터를 key / value의 형태로 파라미터를 받을 수 있다
	//			반드시 바인딩 되는 Map 객체 앞에 @RequestParam Annotation을 작성해야한다
	@PostMapping(value = "/insertBoardMap.do")
	public String insertBoard(@RequestParam Map<String, String> inMap) {
		log.info("@RequestParam을 통해서 name을 key / value를 value의 Map으로 받아줌 : {}",inMap);
		return "redirect:/selectBoard.do";
	}
	
	//TODO 023 전송되는 name을 변경하여 타입과 변수명을 사용
	//			1) a,b,c 문자열 -> 문자열 / d 문자형 숫자 ->정수형
//				2) a는 값을 입력하지 않고 b,c,d는 값을 입력
//				3) a,b,c는 값을 입력 d를 입력하지 않음
//				***페이지의 값의 바인딩은 개체이다. 따라서 null로 선언되는 객체를 사용하면  null값을 받는다
//				만약 기본타입(Primitive type)이라면 타입변환이 되지 않기 때문에 spring 오류
	//post에서 파라미터 받는 것 form-body : enctype = "x-www-form-urlencoded"
	@PostMapping(value = "/insertRequestParam.do")
	public String insertRequestParam(
			@RequestParam("a") String id,
			@RequestParam("b")	String name,
			@RequestParam("c")	String title,
//			@RequestParam("d")	Integer age
			@RequestParam(value="d",defaultValue = "1")	int page,
			@RequestParam(value="e", required = false)	Integer age	//required = false : 값이 없어도 되고, true면 반드시 잇어야함 (javascript마냥)
//			@RequestParam(value="dd",defaultValue = "1")	int page //화면에서 넘겨주는 name이 없어도 디폴트로 받아줌
//				화면에서 받으면 무조건 String 그리고 자동으로 parseInt해주는건데 String값 null인 경우에서는 parseInt가 안되는데 Integer로 받아주면 객체라 null도 가능
//				int인 경우 받아오는 값이 없을때 String ""이라 int로 형변환 오류발생
			
			
			) {
		log.info("전달받은 요청값  id: {}",id );
		log.info("전달받은 요청값 name: {}",name );
		log.info("전달받은 요청값 title: {}", title);
		log.info("전달받은 요청값 page: {}", page);
		log.info("전달받은 요청값 age: {}", age);
		return "redirect:/selectBoard.do";
	}
		
}


















