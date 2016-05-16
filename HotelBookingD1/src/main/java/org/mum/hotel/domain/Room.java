package org.mum.hotel.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Room {
	
	@Id @GeneratedValue
	private int roomNo;
	private String description;
	private boolean bookedStatus;
	private int noOfPersons;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="roomTypeNo")
	private RoomType roomType;
	
	public Room(){
		
	}
	public int getRoomNo() {
		return roomNo;
	}

	public String getDescription() {
		return description;
	}
	public boolean isBookedStatus() {
		return bookedStatus;
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

	public void setBookedStatus(boolean bookedStatus) {
		this.bookedStatus = bookedStatus;
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
	
}
