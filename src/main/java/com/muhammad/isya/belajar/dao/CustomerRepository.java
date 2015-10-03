package com.muhammad.isya.belajar.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.muhammad.isya.belajar.domain.Customer;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, String> {

}
