package com.cg.springboot.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cg.springboot.dao.CustomerRepository;
import com.cg.springboot.dao.LoanRepo;
import com.cg.springboot.dao.UserRepo;
import com.cg.springboot.entity.Customer;
import com.cg.springboot.entity.LoanApplication;
import com.cg.springboot.entity.User;



@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepo;
	@Autowired
	LoanRepo loanRepo;
	@Autowired
	UserRepo userRepo;




	@Override
	public void addCustomer(Customer customer) {
		
		userRepo.save(customer.getUser()); 
		User user =customer.getUser();
		customer.setUser(null);
		
		customerRepo.save(customer);
		customerRepo.updateUser(user,customer.getCustomerId());
		
	}



	@Override
	public List<Customer> viewCustomer() {
		// TODO Auto-generated method stub
		List<Customer> customer = customerRepo.findAll();
		return customer;
		
	}



	@Override
	public Customer viewCustomerById(int custId) {
		Optional<Customer> customer= customerRepo.findById(custId);
		
		return customer.get();
		
	}



	@Override
	public Customer updateCustomer(int custId, Customer customer) {
		Optional<Customer> cust=customerRepo.findById(custId);
		cust.get().setAadharNumber(customer.getAadharNumber());
		cust.get().setCustomerId(custId);
		cust.get().setCustomerName(customer.getCustomerName());
		cust.get().setDateOfBirth(customer.getDateOfBirth());
		cust.get().setEmail(customer.getEmail());
		cust.get().setGender(customer.getGender());
		cust.get().setMobileNumber(customer.getMobileNumber());
		cust.get().setNationality(customer.getNationality());
		cust.get().setPanNumber(customer.getPanNumber());
		cust.get().setUser(customer.getUser());
		
		 customerRepo.save(cust.get());
		 userRepo.save(cust.get().getUser());
		 return cust.get();
		 
		
	}



	@Override
	public Customer deleteCustomer(int custId) {
	//	Optional<Customer> cust = customerRepo.findById(custId);
		Customer cust = customerRepo.getById(custId);
			LoanApplication loan = loanRepo.getByCustomer(cust);
			customerRepo.deleteById(cust.getCustomerId());
			loanRepo.deleteById(loan.getApplicationId());
			
		
			
			return cust;
		
	}







}
