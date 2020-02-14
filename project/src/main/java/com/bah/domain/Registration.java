package com.bah.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="REGISTRATIONS")
public class Registration {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="REGISTRATION_DATE")
	private String date;
	
	@Column(name="NOTES")
	private String notes;

	@Column(name="CUSTOMER_ID")
	@JsonProperty("customer_id")
	private long customer_id;
	
	@Column(name="EVENT_ID")
	@JsonProperty("event_Id")
	private long event_Id;
	
	public Registration() {
		// TODO Auto-generated constructor stub
	}
	public Registration(long id, String date, String notes, long customer_id, long event_Id) {
		super();
		this.id = id;
		this.date = date;
		this.notes = notes;
		this.customer_id = customer_id;
		this.event_Id = event_Id;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public long getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(long customer_id) {
		this.customer_id = customer_id;
	}
	public long getEvent_Id() {
		return event_Id;
	}
	public void setEvent_Id(long event_Id) {
		this.event_Id = event_Id;
	}

}