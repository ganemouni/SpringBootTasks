package com.stackroute;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication

public class MovieAppApplication {
//	@Value("${message}")
//	private String message;

	public static void main(String[] args) {
		SpringApplication.run(MovieAppApplication.class, args);
	}

//	@RequestMapping("hello")
//	String home(){
//		return message;
//	}
}
