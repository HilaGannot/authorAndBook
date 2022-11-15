package com.jb.authorAndBook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(basePackages = {"com.jb.AuthorAndBook"},
		excludeFilters = @ComponentScan.Filter(type = FilterType.ASPECTJ,
				pattern = "com.jb.AuthorAndBook.clr.off.*"))

public class AuthorAndBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthorAndBookApplication.class, args);
	}

}
