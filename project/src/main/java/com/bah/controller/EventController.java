package com.bah.controller;

import java.net.URI;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.bah.object.Event;
import com.bah.repository.EventRepo;

@RestController
@RequestMapping("/events") //http://localhost:8080/project/api/events
public class EventController {
	
	
	@Autowired
	EventRepo eventRepo;
	
	// get event object
	@GetMapping
	public Iterable<Event> getAll(){
		return eventRepo.findAll();
	}
	// get event by Code
	@GetMapping("/{eventCode}")
	
	public Optional<Event> getEventById(@PathVariable ("eventCode") long id){
		return eventRepo.findById(id);
}
	// create event 
	@PostMapping
	public ResponseEntity<?> addEvent(@RequestBody Event newEvent, UriComponentsBuilder uri) {
		if (newEvent.getCode() == null || newEvent.getTitle() == null || newEvent.getDescription() == null) {
			return ResponseEntity.badRequest().build();
		}
		newEvent = eventRepo.save(newEvent);;
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
						.buildAndExpand(newEvent.getCode()).toUri();
		ResponseEntity<?> response = ResponseEntity.created(location).build();
		return response;
	}
	//	update event
	@PutMapping("/{eventCode}")
	public ResponseEntity<?> putEvent(@RequestBody Event newEvent, 
			@PathVariable("eventCode") long eventCode) {
		if (newEvent.getCode() == null 
				|| newEvent.getTitle() == null 
				|| newEvent.getDescription() == null) {
			return ResponseEntity.badRequest().build();
		}
		newEvent=eventRepo.save(newEvent);
		return ResponseEntity.ok().build();
	}
//	// delete event 
	@DeleteMapping("/{eventCode}")
	public void deleteEvent(@PathVariable("eventCode") long eventCode){
		eventRepo.deleteById(eventCode);

}
}
