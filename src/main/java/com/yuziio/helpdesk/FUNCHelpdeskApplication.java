package com.yuziio.helpdesk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FUNCHelpdeskApplication {

	public static void main(String[] args) {
		SpringApplication.run(FUNCHelpdeskApplication.class, args);
	}

}
