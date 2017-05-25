package edu.mum.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

@Entity
public class User implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "firstName")
	@NotEmpty
	@Range(min = 2, max = 255, message = "{Range.field}")	
	private String firstName;
	
	@Column(name = "lastName")
	@NotEmpty
	@Range(min = 2, max = 255, message = "{Range.field}")
	private String lastName;
	
	@Column(name = "email")
	@Email
	private String email;
	
	@Column(name = "ranking")
	@NotNull
	private Integer ranking;
	
	@Column(name = "admin")
	private boolean admin;
	
	@OneToOne(fetch=FetchType.LAZY,  cascade = {CascadeType.MERGE}) 
	@JoinColumn(name="userId") 
	@Valid
	private UserCredential userCredential;
	
	@OneToMany(fetch=FetchType.EAGER, cascade = {CascadeType.PERSIST,CascadeType.MERGE}, mappedBy="user")
	private List<Address> addresses = new ArrayList();

	public User() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getRanking() {
		return ranking;
	}

	public void setRanking(Integer ranking) {
		this.ranking = ranking;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public UserCredential getUserCredential() {
		return userCredential;
	}

	public void setUserCredential(UserCredential userCredential) {
		this.userCredential = userCredential;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
}
