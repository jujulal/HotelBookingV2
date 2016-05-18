package org.mum.hotel.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.mum.hotel.domain.Booking;
import org.mum.hotel.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebserviceController {
	
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
	@Autowired
	BookingService bookingService;
	
	  @RequestMapping(value="/getBookingInfo",method = RequestMethod.GET)
	  @ResponseBody
	    public Booking booking(@RequestParam(value="id", defaultValue="0") int id) {
		  
		  Booking booking = bookingService.getBookingByID(id);
		  if(booking ==null){
			  booking=new Booking();
			  booking.setBookingNo(0);
			
		  }
	       return booking;


}
	  

public class Greeting {

    private final long id;
    private final String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
}
