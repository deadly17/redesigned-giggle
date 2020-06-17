package com.cg.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.entity.Capg_Product;


public interface ProductRepo extends JpaRepository<Capg_Product, Integer>{
	@Query("from Capg_Product where id=:pro_id")
	public Capg_Product getProductById(@Param("pro_id") int pro_id);
}
