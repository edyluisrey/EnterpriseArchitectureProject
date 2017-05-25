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
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import edu.mum.domain.status.RoomStatus;

@Entity
public class Room implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "roomName")
	@NotEmpty
	//@Range(min = 1, max = 255, message = "{Range.field}")
	private String roomName;
	
	@Column(name = "roomNumber")
	@NotEmpty
	//@Range(min = 1, max = 5, message = "{Range.field}")
	private String roomNumber;
	
	@Column(name = "floor")
	@NotEmpty
	@Size(min = 1, max = 5, message = "{Size.field}")
	private String floor;
	
	@Column(name = "building")
	private String building;
	
	@Column(name = "decription")
	private String description;
	
	@Column(name = "price")
	@NotNull
	private Double price;
	
	@Column(name = "roomStatus")
	//@NotNull
	private RoomStatus roomStatus;
	
	@Column(name = "maxGuest")
	@NotNull
	private Integer maxGuest;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
	//@Valid
	private RoomType roomType;
	
	public Room() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public RoomStatus getRoomStatus() {
		return roomStatus;
	}

	public void setRoomStatus(RoomStatus roomStatus) {
		this.roomStatus = roomStatus;
	}

	public Integer getMaxGuest() {
		return maxGuest;
	}

	public void setMaxGuest(Integer maxGuest) {
		this.maxGuest = maxGuest;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

}
