package com.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication

@RestController
public class ProductAppGalaxeBatch5Application {

	public static void main(String[] args) {
		SpringApplication.run(ProductAppGalaxeBatch5Application.class, args);
		System.out.println("hello ");
	}
		

}
