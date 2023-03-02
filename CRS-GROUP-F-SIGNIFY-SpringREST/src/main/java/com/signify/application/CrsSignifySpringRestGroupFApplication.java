package com.signify.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableAutoConfiguration
@ComponentScan("com.signify.*")
@EnableWebMvc

@SpringBootApplication
public class CrsSignifySpringRestGroupFApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrsSignifySpringRestGroupFApplication.class, args);
		System.out.println("success");
	}

}
