package org.mum.hotel.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.mum.hotel.domain.Booking;
import org.mum.hotel.domain.Customer;
import org.mum.hotel.domain.Room;
import org.mum.hotel.service.BookingService;
import org.mum.hotel.service.CustomerService;
import org.mum.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(value={"checkIn","checkOut"})
public class BookingController {

	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private RoomService roomService;
	
	@Autowired
	private CustomerService custService;
	
	
	@RequestMapping(value="/booking",method=RequestMethod.GET)
	public String bookRoom(Model model){
		Booking booking = new Booking();
		model.addAttribute("booking",booking);
		return "/booking/bookRoom";
	}
	
	@RequestMapping(value="/booking/roomsBook", method=RequestMethod.POST)
	public String roomBooking(@Valid @ModelAttribute("booking")Booking booking,BindingResult result,@RequestParam Map<String,String> allRequestParams,Model model){
		if (result.hasErrors()) {
			System.out.println("Got Errors=======");
            return "/booking/bookRoom";
        }
		
		String checkIn = allRequestParams.get("checkIn"); 
		String checkOut = allRequestParams.get("checkOut");
		String num = allRequestParams.get("number");
		
		booking.setCheckInDateTrans(checkIn);
		booking.setCheckoutDateTrans(checkOut);
		
		//Query on service based on params
		List<Room> rooms = bookingService.searchAvailableRooms(checkIn,checkOut,num);
		model.addAttribute("rooms",rooms);
		model.addAttribute("checkIn", checkIn);
		model.addAttribute("checkOut", checkOut);
		model.addAttribute("booking",booking);
		
		//System.out.println("date===="+checkIn+"======="+checkOut+"======"+num+"===="+rooms.size());
		return "/booking/bookingConfirm";
	}
	
	@RequestMapping(value="/booking/confirm", method=RequestMethod.POST)
	public String userConfirm(@ModelAttribute("booking")Booking booking,@RequestParam Map<String,String> allParams,ModelMap model){
	
		String checkIn = (String) model.get("checkIn"); //allParams.get("checkIn"); 
		String checkOut =(String) model.get("checkOut"); //allParams.get("checkOut");
		String custNo = allParams.get("custNo");
		String roomNo = allParams.get("selectedRoom");
		
		//System.out.println("checkIn==="+checkIn+"===checkOut==="+checkOut+"====custNo==="+custNo+"===roomNo=="+roomNo);
		
		Customer customer = custService.getCustomer(Integer.parseInt(custNo));
		Room room = roomService.getRoom(Integer.parseInt(roomNo));
		
	
		booking.setBookedRoom(room);
		booking.setBookingDate(new Date());
		booking.setBookedStatus(true);
		booking.setCustomer(customer);
		
		//Take these conversions to Around AOP
		booking.setActualPrice(room.getRoomType().getRoomPrice());
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		
		//booking.setNoOfDays(noOfDays);int diff = sdf.parse("checkIn").
		try {
			
			booking.setCheckInDate(sdf.parse(checkIn));
			booking.setCheckoutDate(sdf.parse(checkOut));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		bookingService.createBooking(booking);
		return "/booking/book";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	    sdf.setLenient(true);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
	
}
