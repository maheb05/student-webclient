package com.studentapiv1.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class StudentRequest {
	
	private String firstName;
	private String lastName;
	private String email;
	private Long addressId;
}
