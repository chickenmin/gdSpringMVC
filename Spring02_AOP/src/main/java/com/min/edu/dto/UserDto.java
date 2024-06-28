package com.min.edu.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserDto implements Serializable{

	private static final long serialVersionUID = 281859668254310894L;

	private int seq;
	private String id;
	private String password;
	private String name;
	private String address;
	private String phone;
	private String email;
	private String enable;
	private String auth;
	
	public UserDto(String id, String password, String name, String address, String phone, String email) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}
	
}
