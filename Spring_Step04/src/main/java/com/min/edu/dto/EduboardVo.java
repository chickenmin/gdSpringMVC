package com.min.edu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


//TODO 006 객체의 입력 및 출력에 사용되는 VO(Variable Object)
//				view -> controller -> mapping method -> parameter name같은 setter에 바인딩
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EduboardVo {
	
	private int seq;
	private String id;
	private String title;
	private String content;
	private String delflag;
	private String createat;

}
