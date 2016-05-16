package org.mum.hotel.service;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.mum.hotel.dao.BookingDao;
import org.mum.hotel.domain.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BookingService {
	
	@Autowired
	protected BookingDao bookingDAO;
	
	public void addBooking(Booking booking){
		
		Date date=null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//("yyyy-MM-dd'T'HH:mm");
		try {
			date = simpleDateFormat.parse(booking.getCheckInDateTrans());
			System.out.println(date+""+date.getTime());
			booking.setCheckInDate(new java.sql.Date(date.getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		bookingDAO.addBooking(booking);
	}
	
	public List<Booking> getAllBooking(){
		return bookingDAO.getAllBooking();
	}

}
