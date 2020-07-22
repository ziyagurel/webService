package com.ziyagurel.hoaxify.webService.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class User {
	
	@Id
	@GeneratedValue
	private long id;
	
	@NotNull(message="{ziyagurel.hoaxify.validation.constraint.username.NotNull.message}")
	@Size(min= 4, max=255)
	@UniqueUserName
	private String username;
	@NotNull(message="{ziyagurel.hoaxify.validation.constraint.displayName.NotNull.message}")
	@Size(min= 4, max=255)
	private String displayName;
	@NotNull
	@Size(min=4, max=255)
	@Pattern(regexp="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$", message="{ziyagurel.hoaxify.validation.constraint.password.Pattern.message}")
	private String password;
}
