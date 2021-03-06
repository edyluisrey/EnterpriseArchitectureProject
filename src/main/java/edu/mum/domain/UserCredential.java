package edu.mum.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class UserCredential implements Serializable {

	@Id
	@Column(name = "username", nullable = false, unique = true, length = 127)
	@NotEmpty
	@Min(value = 4)
	private String username;
	
	@Column(name = "password")
	@NotEmpty
	@Min(value = 5, message = "{Min.password}")
	private String password;
	
	@NotEmpty
	private String verifyPassword;
	
	@Column(name = "enabled")
	private boolean enabled;
	
	public UserCredential() {
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVerifyPassword() {
		return verifyPassword;
	}

	public void setVerifyPassword(String verifyPassword) {
		this.verifyPassword = verifyPassword;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
}
