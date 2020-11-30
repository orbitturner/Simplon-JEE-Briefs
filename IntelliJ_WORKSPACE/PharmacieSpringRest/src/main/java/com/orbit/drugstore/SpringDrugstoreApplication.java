package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.example.demo.entities","com.example.demo.controller","com.example.demo.entities"})
public class SpringPharmacieApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringPharmacieApplication.class, args);
	}

}
