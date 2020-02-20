package com.bah.repository;

import org.springframework.data.repository.CrudRepository;

import com.bah.object.Registration;

public interface RegistrationRepo extends CrudRepository <Registration, Long> {}