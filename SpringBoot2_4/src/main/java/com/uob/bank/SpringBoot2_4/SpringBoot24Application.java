package com.uob.bank.SpringBoot2_4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBoot24Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot24Application.class, args);
	}

	@GetMapping(value = "/hello", produces = "applications/json")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name){
		return String.format("hello %s!", name);
	}
}
