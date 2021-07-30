package com.flymanager.api.engins;

import com.flymanager.api.engins.dto.EnginRequestDTO;
import com.flymanager.api.engins.service.EnginService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiEnginsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiEnginsApplication.class, args);
	}

	/*
	@Bean
	CommandLineRunner start(EnginService enginService) {
		return args -> {
			enginService.createEngin(new EnginRequestDTO("F-GYKG1","PLANE"));
			enginService.createEngin(new EnginRequestDTO("F-GYKG2","PLANE"));
			enginService.createEngin(new EnginRequestDTO("F-GYKG3","PLANE"));
		};
	}
	*/
}
