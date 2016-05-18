package org.mum.hotel.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.mum.hotel.domain.Booking;
import org.mum.hotel.domain.Booking_;
import org.mum.hotel.domain.Customer;
import org.mum.hotel.domain.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class BookingDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	public void addBooking(Booking booking) {
		entityManager.persist(booking);

	}

	public List<Booking> getAllBooking() {
		 List<Booking> resultList = entityManager.createQuery("select * from Booking", Booking.class).getResultList();
		return resultList;
	}

	public List<Room> searchAvailableRooms(Date checkIn, Date checkOut, int noPersons){
		Query q = entityManager.createQuery("select distinct r from Room r where r.noOfPersons=:num AND r.bookings IS EMPTY OR "
				+ "EXISTS(select b from r.bookings b where (b.checkInDate > :newCheckOut OR b.checkoutDate < :newCheckIn))");
		
		q.setParameter("newCheckIn", checkIn);
		q.setParameter("newCheckOut", checkOut);
		q.setParameter("num", noPersons);
		List<Room> rooms = q.getResultList();
	
		return rooms;
	}

	public Booking getBookingByID(int id) {
		// TODO Auto-generated method stub
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Booking> criteria = builder.createQuery( Booking.class );
		Root<Booking> bookingRoot = criteria.from( Booking.class );
		criteria.select( bookingRoot );
		criteria.where( builder.equal( bookingRoot.get( Booking_.bookingNo), ""+id ) );
		List<Booking> bookings = entityManager.createQuery( criteria ).getResultList();
		Booking tempBooking= null;
		if(bookings!=null&&bookings.size()>0){
			tempBooking=bookings.get(0);
		}
		return tempBooking;
	}
}
