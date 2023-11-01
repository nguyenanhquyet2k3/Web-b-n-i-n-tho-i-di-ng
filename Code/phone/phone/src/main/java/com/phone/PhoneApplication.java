package com.phone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class PhoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhoneApplication.class, args);
	}

}
