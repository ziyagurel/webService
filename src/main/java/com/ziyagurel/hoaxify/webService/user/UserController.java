package com.ziyagurel.hoaxify.webService.user;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ziyagurel.hoaxify.webService.error.ResponseError;
import com.ziyagurel.hoaxify.webService.shared.GenericsResponse;

@RestController
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;
	
	@PostMapping("/api/1.0/users")
	public ResponseEntity<?> createUser(@RequestBody User user) {
		ResponseError error = new ResponseError(400, "Validation Error", "/api/1.0/users");
		Map<String,String> validationErrors = new HashMap<>();
		
		String username = user.getUsername();
		String displayname = user.getDisplayName();
		
		if(username == null || username.isEmpty()) {
			validationErrors.put("username", "Username cannot be null");
		}
		if(displayname == null || displayname.isEmpty()) {
			validationErrors.put("displayname", "displayname cannot be null");
		}
		if(validationErrors.size() > 0) {
			error.setValidationErrors(validationErrors);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
		}
		userService.save(user);
		return ResponseEntity.ok(new GenericsResponse("User Created"));
	}
}
