package com.cg.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.entity.Cartlist;

public interface CartlistRepo extends JpaRepository<Cartlist, Integer>{
	
	@Query("from Cartlist where cartId=:cid")
    public List<Cartlist> getCartListById(@Param("cid") int cid);
	

	@Query("from Cartlist where cust_id=:custid")
    public List<Cartlist> getCartListById1(@Param("custid") Integer custid);

}
