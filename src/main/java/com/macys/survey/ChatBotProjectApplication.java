package com.macys.survey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class ChatBotProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatBotProjectApplication.class, args);
	}
}
