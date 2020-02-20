package com.bah.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
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

import com.bah.object.Customer;
import com.bah.repository.CustomerRepo;

@RestController
@RequestMapping("/customers") //http://localhost:8080/api/customers
public class CustomerController {

	@Autowired
	CustomerRepo customerRepo;

	// get customerRepo object
	@GetMapping
	public Iterable<Customer> getAll() {
		return customerRepo.findAll();
	}

	// get customer by ID
	/*
	@GetMapping("/{customerID}")
	public Optional<Customer> getCustomerByID(@PathVariable("customerID")long id) {
		return customerRepo.findById(id);
	}*/

	// get customer by name

	@GetMapping("/{customerName}")
	public Customer getCustomerByName(@PathVariable("customerName")String name) {
		return customerRepo.findByName(name);
	}

	// add customer
	@PostMapping
	public ResponseEntity<?> addCustomer (@RequestBody Customer newCustomer) {
		if (newCustomer.getID() != 0 || newCustomer.getName() == null || newCustomer.getPassword() == null || newCustomer.getEmail() == null) {
			return ResponseEntity.badRequest().build();
		}
		newCustomer = customerRepo.save(newCustomer);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newCustomer.getID()).toUri();
		ResponseEntity<?> response = ResponseEntity.created(location).build();
		return response;
	}	
	
	// add customer
	@PostMapping("/register")
	public ResponseEntity<?> registerCustomer (@RequestBody String newCustomer) {
		String delimiters = ",|\"|:";
		String[] customer = newCustomer.split(delimiters);
		/*int x = 0;
		for (String str : customer) {
			System.out.println("Index " + x++ + " " + str);
		}*/
		String name = customer[4];
		String pass = customer[10];
		String email = customer[16];
		Customer newUser = new Customer(name, pass, email);
		newUser = customerRepo.save(newUser);
		return ResponseEntity.ok().build();
	}

	// update customer
	@PutMapping("/{customerID}")
	public ResponseEntity<?> putCustomer(@RequestBody Customer newCustomer, @PathVariable("customerID") long customerID) {
		if (newCustomer.getID() != customerID || newCustomer.getName() == null || newCustomer.getPassword() == null || newCustomer.getEmail() == null) {
			return ResponseEntity.badRequest().build();
		}
		newCustomer=customerRepo.save(newCustomer);
		return ResponseEntity.ok().build();
	}

	// delete customer
	@DeleteMapping("/{customerID}")
	public void deleteCustomer(@PathVariable("customerID") long id) {
		customerRepo.deleteById(id);
	}
}
