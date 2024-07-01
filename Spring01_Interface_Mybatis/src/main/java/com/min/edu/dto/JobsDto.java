package com.min.edu.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
public class JobsDto {
	private String job_id;
	private String job_title;
	private String min_salary;
	private String max_salary;
	

}
