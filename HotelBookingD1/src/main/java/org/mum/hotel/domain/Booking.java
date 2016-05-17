package org.mum.hotel.domain;



import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Future;

@Entity
@Table(name = "Booking")
public class Booking {

	
	@Id
	@GeneratedValue
	int bookingNo;
	
	@OneToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="customerNo")
	Customer customer;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="roomNo")
	Room bookedRoom;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="billNo")
	Billing bookingBill;

	Date bookingDate;
	//for date converting purpose
	@Transient
	String checkInDateTrans;
	
	@Future(message="Check-In Date entered is the past.")
	Date checkInDate;
	
	@Transient
	String checkoutDateTrans;
	
	@Future(message="Check-Out Date entered is the past.")
	Date checkoutDate;
	int noOfDays;
	double actualPrice;
	
	private boolean bookedStatus;
	
	
	public Booking(){
		
	}
	public boolean isBookedStatus() {
		return bookedStatus;
	}
	
	public void setBookedStatus(boolean bookedStatus) {
		this.bookedStatus = bookedStatus;
	}

	public Room getBookedRoom() {
		return bookedRoom;
	}

	public void setBookedRoom(Room bookedRoom) {
		this.bookedRoom = bookedRoom;
	}

	public Billing getBookingBill() {
		return bookingBill;
	}

	public void setBookingBill(Billing bookingBill) {
		this.bookingBill = bookingBill;
	}

	public int getBookingNo() {
		return bookingNo;
	}
	public void setBookingNo(int bookingNo) {
		this.bookingNo = bookingNo;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public Date getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}
	public Date getCheckoutDate() {
		return checkoutDate;
	}
	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}
	public int getNoOfDays() {
		return noOfDays;
	}
	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}
	public double getActualPrice() {
		return actualPrice;
	}
	public void setActualPrice(double actualPrice) {
		this.actualPrice = actualPrice;
	}

	public String getCheckInDateTrans() {
		return checkInDateTrans;
	}

	public void setCheckInDateTrans(String checkInDateTrans) {
		this.checkInDateTrans = checkInDateTrans;
	}

	public String getCheckoutDateTrans() {
		return checkoutDateTrans;
	}

	public void setCheckoutDateTrans(String checkoutDateTrans) {
		this.checkoutDateTrans = checkoutDateTrans;
	}
	
	
}
