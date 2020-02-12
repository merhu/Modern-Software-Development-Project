package com.bah.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bah.msd.Event;
import com.bah.msd.EventRepo;

@RestController
@RequestMapping("/convention/events") //http://localhost:8080/project/convention/events
public class EventController {
	
	static final String JSON ="application/json";
	@Autowired
	private EventRepo eventRepo;

	public EventController() {
		// TODO Auto-generated constructor stub
	}
	
	// get event object
	@GetMapping
	@ResponseBody
	public List<Event> getEvent (HttpServletResponse response) {
		response.setStatus(HttpServletResponse.SC_OK);
		return this.eventRepo.getEvents();
	}
	
	/*
	// create customer
	@PostMapping(path = "/customer", consumes = JSON, produces = JSON)
	@ResponseBody
	public CustomerRepo customerRepo (HttpServeletReponse) */

}
