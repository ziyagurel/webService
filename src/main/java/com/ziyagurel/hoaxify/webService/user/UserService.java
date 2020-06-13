package com.ziyagurel.hoaxify.webService.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	IUserRepository repository;
/**
 * Eğer constructor tek bir değer alıyor ise @Autowired edilmeye gerek yok.
 * @param repository
 */
	@Autowired
	public UserService(IUserRepository repository) {
		super();
		this.repository = repository;
	}
	
	public void save(User user) {
		repository.save(user);		
	}
	
}
