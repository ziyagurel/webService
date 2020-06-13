package com.ziyagurel.hoaxify.webService.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	IUserRepository userRepository;
	PasswordEncoder encoder;
/**
 * Eğer constructor tek bir değer alıyor ise @Autowired edilmeye gerek yok.
 * @param repository
 */
	@Autowired
	public UserService(IUserRepository userRepository) {
		this.userRepository = userRepository;
		this.encoder = new BCryptPasswordEncoder();
	}
	
	public void save(User user) {
		user.setPassword(this.encoder.encode(user.getPassword()));
		userRepository.save(user);
	}
	
}
