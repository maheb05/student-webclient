package com.studentapiv1.dto;

import com.studentapiv1.entity.StudentEntity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class StudentResponse {
	
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private AddressResponse addressResponse;
	
	public StudentResponse(StudentEntity studentEntity){
		this.id = studentEntity.getId();
		this.firstName = studentEntity.getFirstName();
		this.lastName = studentEntity.getLastName();
		this.email = studentEntity.getEmail();
		
	}
}
