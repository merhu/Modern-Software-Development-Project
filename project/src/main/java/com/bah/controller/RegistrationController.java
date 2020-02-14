package com.bah.controller;

import java.net.URI;
import java.util.Optional;

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

import com.bah.domain.Event;
import com.bah.domain.Registration;
import com.bah.repository.RegistrationRepo;

@RestController
@RequestMapping("/api/registrations") //http://localhost:8080/api/registrations
public class RegistrationController {

	@Autowired
	RegistrationRepo registrationRepo;

	// get registrationRepo object
	@GetMapping
	public Iterable<Registration> getAll() {
		return registrationRepo.findAll();
	}

	// get registration by ID
	@GetMapping("/{registrationID}")
	public Optional<Registration> getRegistrationByID(@PathVariable("registrationID")long id) {
		return registrationRepo.findById(id);
	}

	// create registration
	@PostMapping
	public ResponseEntity<?> addRegistration(@RequestBody Registration newRegistration, UriComponentsBuilder uri) {

		if (newRegistration.getNotes() == null
				|| newRegistration.getDate() ==null) {
			return ResponseEntity.badRequest().build();
		}
		newRegistration = registrationRepo.save(newRegistration);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(newRegistration.getId()).toUri();
		ResponseEntity<?> response = ResponseEntity.created(location).build();
		return response;
	}

	// update customer
	@PutMapping("/{registrationID}")
	public ResponseEntity<?> putRegistration(@RequestBody Registration newRegistration, @PathVariable("registrationID") long registrationID) {
		if (newRegistration.getId() != registrationID || newRegistration.getNotes() == null || newRegistration.getDate() == null) {
			return ResponseEntity.badRequest().build();
		}
		newRegistration=registrationRepo.save(newRegistration);
		return ResponseEntity.ok().build();
	}
	// delete customer
	@DeleteMapping("/{registrationID}")
	public void deleteRegistration(@PathVariable("registrationID") long id) {
		registrationRepo.deleteById(id);
	}
}



