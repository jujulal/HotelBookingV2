package org.mum.hotel.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.mum.hotel.domain.Booking;
import org.springframework.stereotype.Repository;

@Repository
public class CheckinDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	public void addBooking(Booking booking) {
		// TODO Auto-generated method stub
		entityManager.persist(booking);

	}

	public List<Booking> getAllBooking() {
		// TODO Auto-generated method stub
		 List<Booking> resultList = entityManager.createQuery("select * from Booking", Booking.class).getResultList();
		return resultList;
	}
	
	
	public Booking getByBookingNo(Integer bookingNo){
		
		Booking booking = entityManager.find(Booking.class, bookingNo);
		return booking;
	}
	
	public void updateCheckIn(Booking booking){
	
		
		entityManager.merge(booking);
	}

}
