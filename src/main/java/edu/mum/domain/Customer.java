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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import edu.mum.domain.status.CustomerStatus;

@Entity
public class Customer implements Serializable {

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
	
	@Column(name = "idCard")
	private String idCard;
	
	@Column(name = "passport")
	@NotEmpty
	@Min(value = 10)
	private String passport;
	
	@OneToOne(fetch=FetchType.EAGER,  cascade = CascadeType.ALL) 
	@JoinColumn(name="customerId") 
	@Valid
	private Address address;

	@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
	private List<Reservation> reservations = new ArrayList<>();
	
	@Column(name = "customerStatus")
	@NotNull
	private CustomerStatus customerStatus;

	public Customer() {
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

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public CustomerStatus getCustomerStatus() {
		return customerStatus;
	}

	public void setCustomerStatus(CustomerStatus customerStatus) {
		this.customerStatus = customerStatus;
	}
	
}
