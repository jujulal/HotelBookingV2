package org.mum.hotel.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Billing {
	@Id @GeneratedValue
	private int billNo; 
	private int bookingNo; 
	private double room_charge; 
	private double misc_charge; 
	private double bill_amount; 
	private double tax; 
	private double discount; 
	private String description;

	public Billing(){}
	public int getBillNo() {
		return billNo;
	}
	public void setBillNo(int billNo) {
		this.billNo = billNo;
	}
	public int getBookingNo() {
		return bookingNo;
	}
	public void setBookingNo(int bookingNo) {
		this.bookingNo = bookingNo;
	}
	public double getRoom_charge() {
		return room_charge;
	}
	public void setRoom_charge(double room_charge) {
		this.room_charge = room_charge;
	}
	public double getMisc_charge() {
		return misc_charge;
	}
	public void setMisc_charge(double misc_charge) {
		this.misc_charge = misc_charge;
	}
	public double getBill_amount() {
		return bill_amount;
	}
	public void setBill_amount(double bill_amount) {
		this.bill_amount = bill_amount;
	}
	public double getTax() {
		return tax;
	}
	public void setTax(double tax) {
		this.tax = tax;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
