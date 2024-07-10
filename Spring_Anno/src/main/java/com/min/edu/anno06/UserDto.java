package com.min.edu.anno06;

import org.springframework.stereotype.Component;

@Component
public class UserDto {
	private String name;
	
	public UserDto() {
		this.name = "수요일";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "UserDto [name=" + name + "]";
	}

	public UserDto(String name) {
		super();
		this.name = name;
	}
	
	

}
