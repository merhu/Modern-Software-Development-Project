package com.bah.domain;

import org.springframework.stereotype.Component;

@Component
public class Event {
	
	private String code, title, description;
	
	public Event() {
		// TODO Auto-generated constructor stub
		
	}
	public Event(String code, String title, String description) {
		// TODO Auto-generated constructor stub
		super();
		this.code = code;
		this.title = title;
		this.description = description;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
