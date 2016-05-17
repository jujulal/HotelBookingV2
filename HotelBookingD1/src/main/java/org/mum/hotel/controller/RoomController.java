package org.mum.hotel.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.mum.hotel.domain.Room;
import org.mum.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;



@Controller
@SessionAttributes(value={"roomData"})
public class RoomController {

	@Autowired
	private RoomService roomService;

	@RequestMapping(value="/rooms",method=RequestMethod.GET)
	public String getAllRooms(Model model){
		List<Room> allRooms = roomService.getAllRooms();
		model.addAttribute("rooms", allRooms);
		return "/rooms/roomList";
	}
	
	@RequestMapping(value="/rooms/available",method=RequestMethod.GET)
	public String getAvailableRooms(Model model){
		List<Room> availableRooms = roomService.getAvailableRooms();
		model.addAttribute("rooms", availableRooms);
		return "/rooms/availableRooms";
	}
	
	@RequestMapping(value="/rooms/edit/{roomNo}", method=RequestMethod.POST)
	public String editRoom(@PathVariable int roomNo, Model model){
		Room room = roomService.getRoom(roomNo);
		model.addAttribute("roomData", room);
		return "/rooms/editRoom";
	}
	
	@ModelAttribute("roomData")
	Room getRoom() {
	  return new Room(); 
	}
	
	@RequestMapping(value="/rooms/saveRoom")
	public String saveRoom(@ModelAttribute("roomData") Room room,HttpServletRequest request,Model model){
		double roomPrice = Double.parseDouble(request.getParameter("price"));
		String roomName= request.getParameter("RoomName");
		boolean status = Boolean.parseBoolean(request.getParameter("status"));
		int noPersons = Integer.parseInt(request.getParameter("NoPersons"));
		
		//System.out.println("booked====="+room.isBookedStatus()+"======"+room.getDescription());
		
		room.getRoomType().setRoomName(roomName);
		room.getRoomType().setRoomPrice(roomPrice);
		//room.setBookedStatus(status);
		room.setNoOfPersons(noPersons);
		
		roomService.save(room);
		
		List<Room> allRooms = roomService.getAllRooms();
		model.addAttribute("rooms", allRooms);
		return "/rooms/roomList";
	
	}
	/*public String saveRoom(){
		Room room = new Room();
		RoomType rt = new RoomType("Single bed",45.0);
		room.setDescription("newroom");
		room.setNoOfPersons(1);
		room.setRoomType(rt);
		roomService.save(room);
		
		return "roomList";
	}*/
}
