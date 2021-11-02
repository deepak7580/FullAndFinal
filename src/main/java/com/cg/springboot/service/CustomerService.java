package com.cg.springboot.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cg.springboot.entity.Customer;
import com.cg.springboot.entity.LoanApplication;
import com.cg.springboot.entity.User;
@Service
public interface CustomerService {

	void addCustomer(Customer customer);

	List<Customer> viewCustomer();

	Customer viewCustomerById(int custId);

	Customer updateCustomer(int custId, Customer customer);

	Customer deleteCustomer(int custId);

	



}
