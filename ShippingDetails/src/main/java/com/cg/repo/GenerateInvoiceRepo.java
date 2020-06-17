package com.cg.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.entity.CustomerOrderBean;

public interface GenerateInvoiceRepo extends JpaRepository<CustomerOrderBean, Integer>{
	
	@Query("from CustomerOrderBean where customer_id=:c_id")
	public List<CustomerOrderBean> getInvoiceById(@Param("c_id") int c_id);
	
	

}

