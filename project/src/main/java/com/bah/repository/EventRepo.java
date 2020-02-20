package com.bah.repository;

import org.springframework.data.repository.CrudRepository;

import com.bah.object.Event;

public interface EventRepo extends CrudRepository<Event, Long>{
	
}

	