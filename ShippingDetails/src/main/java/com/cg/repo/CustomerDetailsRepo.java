package com.cg.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.entity.CustomerDetailsBean;


public interface CustomerDetailsRepo extends JpaRepository<CustomerDetailsBean, Integer>{

}
