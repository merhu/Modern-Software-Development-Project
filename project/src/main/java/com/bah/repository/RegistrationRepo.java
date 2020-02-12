package com.bah.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bah.domain.Registration;
@Component
public class RegistrationRepo {
	List<Registration> registration = new ArrayList<Registration>();
	
	public RegistrationRepo() {
		// TODO Auto-generated constructor stub
		this.registration.add(new Registration(1,"a","a.com"));
		this.registration.add(new Registration(2,"b","c.com"));
		this.registration.add(new Registration(3,"c","b.com"));
	}

	public void setRegistration(List<Registration> registration) {
		this.registration = registration;
	}

	public List<Registration> getRegistration() {
		// TODO Auto-generated method stub
		return registration;
	}
	public void addRegistration (Registration registration) {
		this.registration.add(registration);
	}

}
