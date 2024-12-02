package com.studentapiv3.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.studentapiv3.config.FeignConfigs;
import com.studentapiv3.dto.AddressResponse;
import com.studentapiv3.dto.StudentRequest;
import com.studentapiv3.dto.StudentResponse;
import com.studentapiv3.entity.StudentEntity;
import com.studentapiv3.repository.StudentRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class StudentServieImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;
	
//	@Autowired
//	private WebClient webClient;
	
	@Autowired
	FeignConfigs feignConfigs;
	
	
	@Override
	public StudentResponse getStudentById(Long id) {
		
		StudentEntity student = studentRepository.findById(id).get();
		StudentResponse studentResponse = new StudentResponse(student);
		//studentResponse.setAddressResponse(getAddressResponse(student.getId()));
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
		//studentResponse.setAddressResponse(getAddressResponse(student.getId()));
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
	
	/*private AddressResponse getAddressResponse(Long id) {
		return webClient.get()
                .uri("/address/api/getaddress/"+id)
                .retrieve()
                .bodyToMono(AddressResponse.class)
                .block();
	}*/
	
	@CircuitBreaker(name = "addressService")
	private AddressResponse getAddressResponse(Long id) {
		return feignConfigs.getAddressById(id);
	}

}
