package com.example.devapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class DevAppApplication {

	public static void main(String[] args) {
		log.info("Dev Application starting...");
		SpringApplication.run(DevAppApplication.class, args);
		log.info("DevAppApplication has started!");
	}

}
