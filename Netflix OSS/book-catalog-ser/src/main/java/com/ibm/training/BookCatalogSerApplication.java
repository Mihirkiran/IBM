package com.ibm.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient //Optional
public class BookCatalogSerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookCatalogSerApplication.class, args);
	}

}
