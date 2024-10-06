package com.example.pixels_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@OpenAPIDefinition
@EnableCaching
@EnableScheduling
public class PixelsAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(PixelsAppApplication.class, args);
	}

}
