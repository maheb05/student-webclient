package com.studentapiv3.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class AddressResponse {
	
	private Long id;
	private String street;
	private String city;
	private String state;
	private String zipcode;
	
}
