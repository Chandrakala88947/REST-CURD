package com.chandu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SpringBootRestCurdApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestCurdApplication.class, args);
	}

}
