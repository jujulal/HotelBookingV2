package org.mum.hotel.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.mum.hotel.domain.Booking;
import org.mum.hotel.domain.Room;
import org.mum.hotel.domain.RoomType;
import org.mum.hotel.service.BookingService;
import org.mum.hotel.service.CustomerService;
import org.mum.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookingController {
		//controller for hotelbooking by customer
//	@Autowired
//	private CustomerService customerService;
	@Autowired
	private RoomService roomService;
	@Autowired
	private BookingService bookingService;
	
	@RequestMapping(value="/booking", method=RequestMethod.GET)
	public String userForm(Model model){
	
		//injecting Room object
		//List<Room> rooms = roomService.getAvailableRooms();
		//Room room = rooms.get(0);
		Booking booking = new Booking();
		//booking.setBookedRoom(room);
		
		
		
		model.addAttribute("booking",booking);
		
		return "/booking/bookingForm";
	}
	
	@RequestMapping(value="/booking/confirm", method=RequestMethod.POST)
	public String userConfirm(@ModelAttribute("booking")Booking booking){
		
		
		
		//customerService.addCustomer(booking.getCustomer());
		bookingService.addBooking(booking);
		return "/booking/bookingConfirm";
	}
	
	
}
