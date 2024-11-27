package com.studentapiv1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class Studentapiv1Application {
	
	@Value("${address.microservice.url}")
    private String addressMicroserviceUrl;

	public static void main(String[] args) {
		SpringApplication.run(Studentapiv1Application.class, args);
	}
	
	@Bean
	public WebClient webClient() {
		WebClient webClient = WebClient.builder().baseUrl(addressMicroserviceUrl).build();
		return webClient;
	}
	
	

}
