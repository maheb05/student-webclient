package com.studentapiv1.service;

import java.util.List;

import com.studentapiv1.dto.StudentRequest;
import com.studentapiv1.dto.StudentResponse;

public interface StudentService {
	
	public StudentResponse getStudentById(Long id);
	public StudentResponse saveStudentData(StudentRequest studentRequest);
	public List<StudentResponse> getAlStudents();
}
