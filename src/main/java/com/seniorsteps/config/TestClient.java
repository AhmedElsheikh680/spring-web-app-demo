package com.seniorsteps.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

import com.seniorsteps.model.Employee;

public class TestClient {

	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();
		
		Map<String, Object> params = new HashMap<>();
		params.put("id", 101);
		Employee employee  = 
				restTemplate.getForObject("http://localhost:8085/spring-web-app-demoo/api/v1/employee/getById/{id}", Employee.class, params);
		System.out.println(employee);
	}
}
