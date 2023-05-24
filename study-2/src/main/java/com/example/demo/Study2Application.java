package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages= {"controller, user, security, common, chat, dto"})
@EntityScan(basePackages = {"model"})
@EnableJpaRepositories(basePackages = {"repository"})
public class Study2Application {

	public static void main(String[] args) {
		SpringApplication.run(Study2Application.class, args);
	}

}
