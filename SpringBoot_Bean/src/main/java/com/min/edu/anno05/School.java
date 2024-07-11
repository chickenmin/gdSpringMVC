package com.min.edu.anno05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
public class School {
	/*
	 * ByType @Autowired @Qualifier
	 * ByName @Resource(name="")
	 */
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
