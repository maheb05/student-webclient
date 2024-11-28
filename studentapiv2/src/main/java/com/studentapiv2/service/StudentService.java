package com.studentapiv2.service;

import java.util.List;

import com.studentapiv2.dto.StudentRequest;
import com.studentapiv2.dto.StudentResponse;

public interface StudentService {
	
	public StudentResponse getStudentById(Long id);
	public StudentResponse saveStudentData(StudentRequest studentRequest);
	public List<StudentResponse> getAlStudents();
}
