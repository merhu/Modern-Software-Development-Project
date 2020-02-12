package com.bah.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bah.domain.Registration;
import com.bah.repository.RegistrationRepo;

		@RestController
		@RequestMapping("/convention/registration") //http://localhost:8080/project/convention/customers
		public class RegistrationController {			
			static final String JSON ="application/json";
			@Autowired
			private RegistrationRepo registrationRepo;

				// TODO Auto-generated constructor stub
		
			// get customerRepo object
			@GetMapping
			@ResponseBody
			public List<Registration> getRegistration (HttpServletResponse response) {
				response.setStatus(HttpServletResponse.SC_OK);
				return this.registrationRepo.getRegistration();
			}
			
			/*
			// create customer
			@PostMapping(path = "/customer", consumes = JSON, produces = JSON)
			@ResponseBody
			public CustomerRepo customerRepo (HttpServeletReponse) */

		}
	


