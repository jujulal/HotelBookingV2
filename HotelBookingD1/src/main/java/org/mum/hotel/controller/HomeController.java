package org.mum.hotel.controller;


import org.mum.hotel.domain.Room;
import org.mum.hotel.domain.RoomType;
import org.mum.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */


@Controller
public class HomeController {
	
	//@Autowired
	//private RoomService roomService;

	


	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value="/",method = RequestMethod.GET) //value = "/", method = RequestMethod.GET)Locale locale,
	public String home(Model model) {
	//	logger.info("Welcome home! The client locale is {}.", locale);
		//test hibernate
		//RoomType rt = new RoomType("Single bed room",45.0);
		//roomDao.create("new room", false, 1, rt);
		/*Room room = new Room();
		RoomType rt = new RoomType("Single bed",45.0);
		room.setDescription("newroom");
		room.setNoOfPersons(1);
		room.setRoomType(rt);
		this.roomService.save(room);*/
		
		//Date date = new Date();
		//DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		//String formattedDate = dateFormat.format(date);
		
		//model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
}
