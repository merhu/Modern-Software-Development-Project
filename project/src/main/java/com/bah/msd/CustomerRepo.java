package com.bah.msd;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepo extends CrudRepository <Customer, Long> {}