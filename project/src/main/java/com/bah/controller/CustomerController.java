package com.bah.controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.bah.msd.Customer;
import com.bah.msd.CustomerRepo;

@RestController
@RequestMapping("/api/customers") //http://localhost:8080/api/customers
public class CustomerController {
	
	@Autowired
	CustomerRepo customerRepo;

	// get customerRepo object
	@GetMapping
	public Iterable<Customer> getAll() {
		return customerRepo.findAll();
	}
	
	// get customer by ID
	@GetMapping("/{customerID}")
	public Optional<Customer> getCustomerByID(@PathVariable("customerID")long id) {
		return customerRepo.findById(id);
	}
	
	// create customer
	@PostMapping
	public ResponseEntity<?> addCustomer (@RequestBody Customer newCustomer, UriComponentsBuilder uri) {
		if (newCustomer.getID() != 0 || newCustomer.getName() == null || newCustomer.getEmail() == null) {
			return ResponseEntity.badRequest().build();
		}
		newCustomer = customerRepo.save(newCustomer);;
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
						.buildAndExpand(newCustomer.getID()).toUri();
		ResponseEntity<?> response = ResponseEntity.created(location).build();
		return response;
	}

	// update customer
	@PutMapping("/{customerID}")
	public ResponseEntity<?> putCustomer(@RequestBody Customer newCustomer, @PathVariable("customerId") long customerID) {
		if (newCustomer.getID() != 0 || newCustomer.getName() == null || newCustomer.getEmail() == null) {
			return ResponseEntity.badRequest().build();
		}
		newCustomer=customerRepo.save(newCustomer);
		return ResponseEntity.ok().build();
	}
}
