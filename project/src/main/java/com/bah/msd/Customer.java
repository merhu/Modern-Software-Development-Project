package com.bah.msd;

import org.springframework.stereotype.Component;

@Component
public class Customer {
	
	private String name, email;
	private int id;
	
	public Customer() {
		// TODO Auto-generated constructor stub
		
	}
	public Customer(int id, String name, String email) {
		// TODO Auto-generated constructor stub
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
