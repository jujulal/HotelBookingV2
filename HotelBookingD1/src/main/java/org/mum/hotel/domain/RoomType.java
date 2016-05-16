package org.mum.hotel.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class RoomType {
	@Id @GeneratedValue
	private int roomTypeNo;
	private String roomName;
	private double roomPrice;
	
	public RoomType(){
		
	}
	public RoomType(String roomName,double roomPrice){
		this.roomName = roomName;
		this.roomPrice = roomPrice;
	}
	
	public int getRoomTypeNo() {
		return roomTypeNo;
	}
	public void setRoomTypeNo(int roomTypeNo) {
		this.roomTypeNo = roomTypeNo;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public double getRoomPrice() {
		return roomPrice;
	}
	public void setRoomPrice(double roomPrice) {
		this.roomPrice = roomPrice;
	}
	
	
}
