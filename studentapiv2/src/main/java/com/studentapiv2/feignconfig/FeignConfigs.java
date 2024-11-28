package com.studentapiv2.feignconfig;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.studentapiv2.dto.AddressResponse;

@FeignClient(url = "${address.microservice.url}" , value = "address-v2", path = "/address/api")
public interface FeignConfigs {
	
	@GetMapping("/getaddress/{id}")
	public AddressResponse getAddressById(@PathVariable Long id);
}
