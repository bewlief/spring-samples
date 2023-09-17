package com.java.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.springboot.model.Student;

@RestController
public class StudentController {
	
	List<Student> students = new ArrayList<>();
	
	@GetMapping("/students")
	public List<Student> students(){
		
		students.add(new Student(1, "Divya", "Dangroshiya"));
		students.add(new Student(2, "Parth", "Dangroshiya"));
		
		return students;
	}
	
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/students")
	public Student createStudent(@RequestBody Student student) {
		
		students.add(student);
		return student;
	}

}
