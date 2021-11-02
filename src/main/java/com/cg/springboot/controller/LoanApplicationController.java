package com.cg.springboot.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.springboot.entity.LoanApplication;
import com.cg.springboot.service.LoanService;


@RestController
public class LoanApplicationController {
	@Autowired
	LoanService loanService;
	
	
	@PostMapping("/add")
	public LoanApplication addLoanApplication(@RequestBody  LoanApplication loanApplication) {
		loanService.addLoanApplication(loanApplication);
		return loanApplication;
	}

//	@PostMapping("/add/{userId}")
//	public LoanApplication addLoan(@PathVariable("userId") String userId,    @RequestBody  LoanApplication loanApplication) {
//		loanService.addLoan(userId,loanApplication);
//		return loanApplication;
//	}

}
