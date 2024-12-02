package com.studentapiv3.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.studentapiv3.dto.AddressResponse;

@FeignClient(value = "api-gateway")
public interface FeignConfigs {
	
	@GetMapping("/addressapiv3/address/api/getaddress/{id}")
	public AddressResponse getAddressById(@PathVariable Long id);
}
