package com.muhammad.isya.belajar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.muhammad.isya.belajar.dao.CustomerRepository;
import com.muhammad.isya.belajar.domain.Customer;

@RestController
public class CustomerController {

	@Autowired
	private CustomerRepository repository;

	@RequestMapping(value = "/customer", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void insert(@RequestBody Customer customer) {
		repository.save(customer);
	}

	@RequestMapping(value = "/allcustomer", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public Iterable<Customer> allCustomer() {
		return repository.findAll();
	}
}
