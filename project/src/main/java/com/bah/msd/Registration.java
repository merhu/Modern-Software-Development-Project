package com.bah.msd;

import org.springframework.stereotype.Component;

@Component
public class Registration {

	private String date;
	private int id;
	private String notes;
	
	public Registration() {
		// TODO Auto-generated constructor stub
		
	}
	public Registration(int id, String date, String notes) {
		super();
		this.date = date;
		this.id = id;
		this.notes = notes;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	@Override
	public String toString() {
		return "Registration [date=" + date + ", id=" + id + ", notes=" + notes + "]";
	}

	
}
