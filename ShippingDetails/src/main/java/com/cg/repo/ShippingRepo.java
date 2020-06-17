package com.cg.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import com.cg.entity.ShippingDetailsBean;

public interface ShippingRepo extends JpaRepository<ShippingDetailsBean, Integer> {
	
	@Query("from ShippingDetailsBean where customer_id=:custid")
	public List<ShippingDetailsBean>find(@PathVariable("custid")int custid);

}