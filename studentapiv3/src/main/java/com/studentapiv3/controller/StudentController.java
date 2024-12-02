package com.studentapiv3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentapiv3.dto.StudentRequest;
import com.studentapiv3.dto.StudentResponse;
import com.studentapiv3.service.StudentService;

@RestController
@RequestMapping("/student/api")
@CrossOrigin(origins = "http://localhost:8080")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@PostMapping("/createstudent")
	public StudentResponse createStudent(@RequestBody StudentRequest studentRequest) {
		return studentService.saveStudentData(studentRequest);
	}
	
	@GetMapping("/getstudent/{id}")
	public StudentResponse getStudentById(@PathVariable Long id) {
		return studentService.getStudentById(id);
	}
	
	@GetMapping("/all")
	public List<StudentResponse> getAllStudentsData(){
		return studentService.getAlStudents();
	}
}
