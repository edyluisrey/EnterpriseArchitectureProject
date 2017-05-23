package edu.mum.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private Integer ranking;
	
	private boolean admin;
	
	private UserCredential userCredential;
	
	private List<Address> addresses = new ArrayList();
}
