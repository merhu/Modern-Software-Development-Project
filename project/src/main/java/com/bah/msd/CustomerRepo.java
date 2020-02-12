package com.bah.msd;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class CustomerRepo {

	List<Customer> customers = new ArrayList<Customer>();

	public CustomerRepo() {
		// TODO Auto-generated constructor stub
		this.customers.add(new Customer(1,"a","a.com"));
		this.customers.add(new Customer(2,"b","c.com"));
		this.customers.add(new Customer(3,"c","b.com"));
	}
	
	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	
	public void addCustomer (Customer customer) {
		this.customers.add(customer);
	}
	
	public String toString() {
		return "Customer " + customers;
	}
	
}
