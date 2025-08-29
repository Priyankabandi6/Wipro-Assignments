package com.example.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients

public class BloodServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BloodServiceApplication.class, args);
	}

}
