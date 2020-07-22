package com.ziyagurel.hoaxify.webService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

import com.ziyagurel.hoaxify.webService.user.User;
import com.ziyagurel.hoaxify.webService.user.UserService;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class WebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner createInitialUsers(UserService userService) {
		return (args) -> {
			User user = new User();
			user.setUsername("display1");
			user.setPassword("P4ssword");
			user.setDisplayName("displayname1");
			userService.save(user);
		};
	}

}
