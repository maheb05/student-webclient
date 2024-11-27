package com.studentapiv1.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.studentapiv1.dto.AddressResponse;
import com.studentapiv1.dto.StudentRequest;
import com.studentapiv1.dto.StudentResponse;
import com.studentapiv1.entity.StudentEntity;
import com.studentapiv1.repository.StudentRepository;

@Service
public class StudentServieImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	private WebClient webClient;
	
	
	@Override
	public StudentResponse getStudentById(Long id) {
		
		StudentEntity student = studentRepository.findById(id).get();
		StudentResponse studentResponse = new StudentResponse(student);
		studentResponse.setAddressResponse(getAddressResponse(student.getId()));
		return studentResponse;
		
	}

	@Override
	public StudentResponse saveStudentData(StudentRequest studentRequest) {
		
		StudentEntity student = new StudentEntity();
		student.setFirstName(studentRequest.getFirstName());
		student.setLastName(studentRequest.getLastName());
		student.setEmail(studentRequest.getEmail());
		student.setAddressId(studentRequest.getAddressId());
		
		student = studentRepository.save(student);
		
		StudentResponse studentResponse = new StudentResponse(student);
		studentResponse.setAddressResponse(getAddressResponse(student.getId()));
		
		return studentResponse;
	}
	
	public List<StudentResponse> getAlStudents() {
		return studentRepository.findAll()
				.stream()
				.map(student -> {
					StudentResponse response = new StudentResponse(student);
					response.setAddressResponse(getAddressResponse(student.getId()));
					return response;
				})
				.collect(Collectors.toList());
	}
	
	private AddressResponse getAddressResponse(Long id) {
		return webClient.get()
                .uri("/address/api/getaddress/"+id)
                .retrieve()
                .bodyToMono(AddressResponse.class)
                .block();
	}

}
