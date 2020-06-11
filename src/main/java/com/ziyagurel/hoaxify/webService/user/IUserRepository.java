package com.ziyagurel.hoaxify.webService.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
	
}
