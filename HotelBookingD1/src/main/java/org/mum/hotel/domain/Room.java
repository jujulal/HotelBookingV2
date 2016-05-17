package org.mum.hotel.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Room {
	
	@Id @GeneratedValue
	private int roomNo;
	private String description;
	private int noOfPersons;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="roomTypeNo")
	private RoomType roomType;
	
	@OneToMany(mappedBy="bookedRoom")
	private List<Booking> bookings;
	
	public Room(){
		
	}
	public int getRoomNo() {
		return roomNo;
	}

	public String getDescription() {
		return description;
	}

	public int getNoOfPersons() {
		return noOfPersons;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setNoOfPersons(int noOfPersons) {
		this.noOfPersons = noOfPersons;
	}
	public RoomType getRoomType() {
		return roomType;
	}
	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}
	public List<Booking> getBookings() {
		return bookings;
	}
	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}
	
}
