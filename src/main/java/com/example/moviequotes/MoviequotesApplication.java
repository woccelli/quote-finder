package com.example.moviequotes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class MoviequotesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviequotesApplication.class, args);
	}

}
