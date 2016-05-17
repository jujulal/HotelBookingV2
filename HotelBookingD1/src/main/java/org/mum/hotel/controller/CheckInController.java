package org.mum.hotel.controller;

import org.mum.hotel.domain.Booking;
import org.mum.hotel.service.CheckinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CheckInController {

	@Autowired
	private CheckinService checkinService;

	@RequestMapping(value = "/checkin")
	public String loadcheckInForm(Model model) {

		Booking booking = new Booking();
		model.addAttribute("booking", booking);
		return "/checkin/checkInForm";
	}

	@RequestMapping(value = "/checkin/confirm", method = RequestMethod.GET)
	public String checkInConfirm(@RequestParam("bookingNo") String bookingNo,
			@ModelAttribute("booking") Booking booking, Model model) {
		booking = checkinService.getByBookingNo(bookingNo);

		//bookingService.updateCheckIn(booking);
		model.addAttribute(booking);
		return "/checkin/checkInConfirm";
	}

	@RequestMapping(value = "/checkin/confirmByPass", method = RequestMethod.GET)
	public String checkInUpdate(@RequestParam("bookingNo") String bookingNo, @ModelAttribute("booking") Booking booking,
			Model model) {
		System.out.println("updated" + bookingNo);
		// return "/checkin/confirm";
		booking = checkinService.getByBookingNo(bookingNo);

		checkinService.updateCheckIn(booking);
		model.addAttribute(booking);
		return "/checkin/checkInConfirm";
	}

	//for checkout
	@RequestMapping(value = "/checkout")
	public String loadcheckOutForm(Model model) {

		Booking booking = new Booking();
		model.addAttribute("booking", booking);
		return "/checkin/checkOutForm";
	}
	
	@RequestMapping(value = "/checkout/confirm", method = RequestMethod.GET)
	public String checkOutConfirm(@RequestParam("bookingNo") String bookingNo,
			@ModelAttribute("booking") Booking booking, Model model) {
		booking = checkinService.getByBookingNo(bookingNo);

		model.addAttribute(booking);
		return "/checkin/checkOutConfirm";
	}
	
	
	@RequestMapping(value = "/checkout/confirmByPass", method = RequestMethod.GET)
	public String checkOutUpdate(@RequestParam("bookingNo") String bookingNo, @ModelAttribute("booking") Booking booking,
			Model model) {
		//System.out.println("updated" + bookingNo);
		booking = checkinService.getByBookingNo(bookingNo);

		checkinService.updateCheckOut(booking);
		model.addAttribute(booking);
		return "/checkin/checkInConfirm";
	}
	
	@RequestMapping(value="/checkout/confirmPayment")
	public String checkOutMakePayment(){
		
		return "/checkin/checOutPayment";
	}
}
