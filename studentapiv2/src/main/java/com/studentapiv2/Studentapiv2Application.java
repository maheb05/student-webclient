package com.studentapiv2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableFeignClients("com.studentapiv2.feignconfig")
public class Studentapiv2Application {
	
	/*@Value("${address.microservice.url}")
    private String addressMicroserviceUrl;*/

	public static void main(String[] args) {
		SpringApplication.run(Studentapiv2Application.class, args);
	}
	
	/*@Bean
	public WebClient webClient() {
		WebClient webClient = WebClient.builder().baseUrl(addressMicroserviceUrl).build();
		return webClient;
	}*/
	
	

}
