package com.cg.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.springboot.entity.User;
@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

}
