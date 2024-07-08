package com.min.edu.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
public class UserVo {

	private String id;
	private String name;
	private String password;
	private String email;
	private String auth;
	private String enable;
	private String joinindate;
}
