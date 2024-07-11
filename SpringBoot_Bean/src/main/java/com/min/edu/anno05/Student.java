package com.min.edu.anno05;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * Spring Bean Configuration을 통해서 xml의 <benn>으로 등록하여 같은 타입의 여러개의 bean을 만들어냄
 * @Component를 통해서 작성하면 안된다
 */
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {

	private String name;
	private String addr;
	private int age;
	
}
