package com.studentapiv3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Studentapiv3Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Studentapiv3Application.class, args);
	}
	
}
