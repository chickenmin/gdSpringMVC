package com.min.edu.bean02;

public class JobAddress {
	private EmployeeAddress addr;
	private String jobName;
	
	public JobAddress() {
		addr = new EmployeeAddress("고라파억", "물","64");
	}

	public JobAddress(EmployeeAddress addr, String jobName) {
		super();
		this.addr = addr;
		this.jobName = jobName;
	}

	@Override
	public String toString() {
		return "JobAddress [addr=" + addr + ", jobName=" + jobName + "]";
	}
	
	
}
