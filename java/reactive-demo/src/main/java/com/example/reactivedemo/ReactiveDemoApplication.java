package com.example.reactivedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.reactivedemo")

@EnableR2dbcRepositories
public class ReactiveDemoApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext =
		SpringApplication.run(ReactiveDemoApplication.class, args);
//		System.out.println("bean list:");
//		Arrays.stream(applicationContext.getBeanDefinitionNames()).forEach(System.out::println);
	}

}
