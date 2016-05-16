package org.mum.hotel.service;

import java.util.List;

import org.mum.hotel.dao.RoomDAO;
import org.mum.hotel.domain.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoomService {

	@Autowired
	private RoomDAO roomDao;
	
	public void save(Room room){
		roomDao.update(room);
	}
	
	public List<Room> getAllRooms(){
		return roomDao.getAll();
	}
	
	public List<Room> getAvailableRooms(){
		return roomDao.getAvailableRooms();
	}
	
	public Room getRoom(int roomNo){
		return roomDao.getRoom(roomNo);
	}
}
