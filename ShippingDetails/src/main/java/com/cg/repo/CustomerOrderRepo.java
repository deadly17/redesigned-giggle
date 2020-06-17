package com.cg.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.entity.CustomerOrderBean;

public interface CustomerOrderRepo extends JpaRepository<CustomerOrderBean, Integer>{

	@Query("from CustomerOrderBean where orderId=:order_id")
	public CustomerOrderBean getOrderById(@Param("order_id") int order_id);
}
