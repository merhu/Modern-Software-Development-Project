package com.bah.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.util.UriComponentsBuilder;

import com.bah.object.Customer;
import com.bah.repository.CustomerRepo;

import io.opentracing.Span;
import io.opentracing.Tracer;

@RestController
@RequestMapping("/customers") //http://localhost:8080/api/customers
public class CustomerController {

	@Autowired
	CustomerRepo customerRepo;
	
	@Autowired
	private Tracer tracer;

	// get customerRepo object
	@GetMapping
	public Iterable<Customer> getAll() {
		Span span = tracer.buildSpan("get customers").start();
		span.setTag("http.status_code",201);
		span.finish();
		return customerRepo.findAll();
	}

	@GetMapping("/{customerName}")
	public Customer getCustomerByName(@PathVariable("customerName")String name) {
		Span span = tracer.buildSpan("get customer by name").start();
		span.setTag("http.status_code",201);
		span.finish();
		return customerRepo.findByName(name);
	}

	@PostMapping
	public ResponseEntity<?> addCustomer(@RequestBody Customer newCustomer, UriComponentsBuilder uri) {
		Span span = tracer.buildSpan("add customer").start();
		if (newCustomer.getID() != 0 || newCustomer.getName() == null || newCustomer.getEmail() == null) {
			// Reject we'll assign the customer id
			return ResponseEntity.badRequest().build();
		}
		newCustomer = customerRepo.save(newCustomer);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newCustomer.getID()).toUri();
		ResponseEntity<?> response = ResponseEntity.created(location).build();
		span.setTag("http.status_code",201);
		span.finish();
		return response;
	}
	
	// update customer
	@PutMapping("/{customerID}")
	public ResponseEntity<?> putCustomer(@RequestBody Customer newCustomer, @PathVariable("customerID") long customerID) {
		Span span = tracer.buildSpan("update customer").start();
		if (newCustomer.getID() != customerID || newCustomer.getName() == null || newCustomer.getPassword() == null || newCustomer.getEmail() == null) {
			return ResponseEntity.badRequest().build();
		}
		newCustomer=customerRepo.save(newCustomer);
		span.setTag("http.status_code",201);
		span.finish();
		return ResponseEntity.ok().build();
	}

	// delete customer
	@DeleteMapping("/{customerID}")
	public void deleteCustomer(@PathVariable("customerID") long id) {
		Span span = tracer.buildSpan("delete customer").start();
		span.setTag("http.status_code",201);
		span.finish();
		customerRepo.deleteById(id);
	}
}
