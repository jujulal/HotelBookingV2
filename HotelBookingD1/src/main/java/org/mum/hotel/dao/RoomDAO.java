package org.mum.hotel.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.mum.hotel.domain.Room;
import org.mum.hotel.domain.RoomType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class RoomDAO {

	@PersistenceContext
    protected EntityManager em;
	
	
	public void create(Room room){
		em.persist(room);
	}
	
	public void delete(Room room){
		em.remove(room);
	}
	
	public void update(Room room){
		em.merge(room);
	}
	
	public List<Room> getAll(){
		List<Room> result = em.createQuery("from Room").getResultList();
		return result;
	}
	
	public List<Room> getAvailableRooms(){
		List<Room> result = em.createQuery("select r from Room r where r.bookedStatus=false").getResultList();
		return result;
	}
	
	public Room getRoom(int roomNo){
		Room rm = em.find(Room.class, roomNo);
		return rm;
	}
	
}
