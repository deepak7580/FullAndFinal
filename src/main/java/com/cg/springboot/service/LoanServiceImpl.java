package com.cg.springboot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.springboot.dao.CustomerRepository;
import com.cg.springboot.dao.LoanRepo;
import com.cg.springboot.entity.Customer;
import com.cg.springboot.entity.LoanApplication;
import com.cg.springboot.entity.User;
@Service
public class LoanServiceImpl implements LoanService {
	@Autowired
	LoanRepo loanrepo;
	@Autowired
	CustomerRepository custRepo;

	@Override
	public void addLoanApplication(LoanApplication loanApplication) {
		//loanrepo.save(loanApplication);
		Customer cust=loanApplication.getCustomer();
		loanApplication.setCustomer(null);
		loanrepo.save(loanApplication);
		loanrepo.updateCustomer(cust, loanApplication.getApplicationId());
		//customerRe.updateUser(user,customer.getCustomerId());
		
	}
	
	
	


//	@Override
//	public void addLoan(String userId, LoanApplication loanApplication) {
//		
//		Optional<Customer> cst1=custRepo.findById(userId);
//		loanApplication.setCustomer(cst1);
//		
//		loanrepo.save(loanApplication);
//		
//		
//	}

}



