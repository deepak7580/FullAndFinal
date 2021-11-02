package com.cg.springboot.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cg.springboot.entity.Customer;
import com.cg.springboot.entity.LoanApplication;
import com.cg.springboot.entity.User;

public interface LoanRepo extends JpaRepository<LoanApplication, Long> {
	@Query("from LoanApplication ref where ref.customer=?1")
	public LoanApplication getByCustomer(Customer customer);
	
	@Query("from LoanApplication l where l.applicationId=?1")
	public LoanApplication getById(long id);
	@Transactional
	@Modifying
	@Query("update LoanApplication l set l.customer=?1 where l.applicationId=?2")
	public void updateCustomer(Customer c,long id);

}
