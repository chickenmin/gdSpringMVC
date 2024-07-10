package com.min.edu.anno05;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class School {
	
	@Autowired
	@Qualifier(value = "stu01")
	private Student student;
	
	@Resource(name = "stu02")
	private Student studentResource;
	
	private int grade;
	
	public School() {
	}

	public School(Student student, int grade) {
		super();
		this.student = student;
		this.grade = grade;
	}


	@Override
	public String toString() {
		return "School [student=" + student + ", studentResource=" + studentResource + ", grade=" + grade + "]";
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Student getStudentResource() {
		return studentResource;
	}

	public void setStudentResource(Student studentResource) {
		this.studentResource = studentResource;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
	
}
