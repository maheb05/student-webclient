package com.studentapiv3.service;

import java.util.List;

import com.studentapiv3.dto.StudentRequest;
import com.studentapiv3.dto.StudentResponse;

public interface StudentService {
	
	public StudentResponse getStudentById(Long id);
	public StudentResponse saveStudentData(StudentRequest studentRequest);
	public List<StudentResponse> getAlStudents();
}
