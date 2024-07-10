package com.min.edu.bean02;

public class EmployeeAddress {

	
	
	@Override
	public String toString() {
		return "EmployeeAddress [name=" + name + ", addr=" + addr + ", phone=" + phone + "]";
	}
	private String name;
	private String addr;
	private String phone;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public EmployeeAddress(String name, String addr, String phone) {
		super();
		this.name = name;
		this.addr = addr;
		this.phone = phone;
	}
	public EmployeeAddress() {
		super();
	}
	
	
}
