package com.bank.eurekaclientuserdetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class EurekaClientUserDetailsApplication {

	@RequestMapping("/")
	public String home() {
		return "Hello eureka-client-user-details";
	}
	public static void main(String[] args) {
		SpringApplication.run(EurekaClientUserDetailsApplication.class, args);
	}

}
