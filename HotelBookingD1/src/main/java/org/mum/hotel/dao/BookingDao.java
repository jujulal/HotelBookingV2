package org.mum.hotel.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.mum.hotel.domain.Booking;
import org.mum.hotel.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class BookingDao {
	
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

}
