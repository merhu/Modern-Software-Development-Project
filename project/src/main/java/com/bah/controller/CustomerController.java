package com.bah.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bah.msd.Customer;
import com.bah.msd.CustomerRepo;

@RestController
@RequestMapping("/api/customers") //http://localhost:8080/project/convention/customers
public class CustomerController {
	
	static final String JSON ="application/json";
	@Autowired
	private CustomerRepo customerRepo;

	public CustomerController() {
		// TODO Auto-generated constructor stub
	}
	
	// get customerRepo object
	@GetMapping
	@ResponseBody
	public List<Customer> getCustomer (HttpServletResponse response) {
		response.setStatus(HttpServletResponse.SC_OK);
		return this.customerRepo.getCustomers();
	}
	
	/*
	// create customer
	@PostMapping(path = "/customer", consumes = JSON, produces = JSON)
	@ResponseBody
	public CustomerRepo customerRepo (HttpServeletReponse) */

}
