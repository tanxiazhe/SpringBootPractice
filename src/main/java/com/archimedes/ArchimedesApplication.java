package com.archimedes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.archimedes.controller","com.archimedes.persistence","com.archimedes.service"})
public class ArchimedesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArchimedesApplication.class, args);
	}
}
