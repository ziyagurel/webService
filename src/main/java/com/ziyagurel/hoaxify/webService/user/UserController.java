package com.ziyagurel.hoaxify.webService.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ziyagurel.hoaxify.webService.shared.GenericsResponse;

@RestController
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;
	
	@PostMapping("/api/1.0/users")
	public GenericsResponse createUser(@RequestBody User user) {
		userService.save(user);
		return new GenericsResponse("user created");
	}
}
