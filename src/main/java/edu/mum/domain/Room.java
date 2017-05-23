package edu.mum.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import edu.mum.domain.status.RoomStatus;

@Entity
public class Room {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "roomName")
	private String roomName;
	
	@Column(name = "roomNumber")
	private String roomNumber;
	
	@Column(name = "floor")
	private String floor;
	
	@Column(name = "building")
	private String building;
	
	@Column(name = "decription")
	private String description;
	
	@Column(name = "price")
	private Double price;
	
	@Column(name = "roomStatus")
	private RoomStatus roomStatus;
	
	@Column(name = "maxGuest")
	private Integer maxGuest;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
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
