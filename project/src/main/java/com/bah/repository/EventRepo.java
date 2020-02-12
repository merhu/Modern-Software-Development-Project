package com.bah.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bah.domain.Event;
@Component
public class EventRepo {

	List<Event> events = new ArrayList<Event>();

	public EventRepo() {
		// TODO Auto-generated constructor stub
		this.events.add(new Event("1","a","a.com"));
		this.events.add(new Event("2","b","c.com"));
		this.events.add(new Event("3","c","b.com"));
	}
	
	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public void addEvent (Event events) {
		this.events.add(events);
	}
	
	public String toString() {
		return "Events " + events;
	}
	
}
