package com.cg.repo;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import com.cg.entity.DeliveryDetailsBean;

	public interface DeliveryRepo extends JpaRepository<DeliveryDetailsBean, Integer>{
	
		@Query("from DeliveryDetailsBean where customer_id=:del_id")
		public List<DeliveryDetailsBean> find(@PathVariable("del_id") int del_id);
		

	}



