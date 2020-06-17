package com.cg.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.entity.Capg_Product;

public interface Capg_Search_Repo extends JpaRepository<Capg_Product, Integer>{

	@Query("from Capg_Product where name=:na")
	public List<Capg_Product> getProductByName(@Param("na")String name);
	
	@Query("from Capg_Product where brand=:br")
	public List<Capg_Product> getProductByBrand(@Param("br")String brand);
	
	@Query("from Capg_Product where category=:ca")
	public List<Capg_Product> getProductByCategory(@Param("ca")String category);
	
	@Query("from Capg_Product ORDER BY price ASC")
	public List<Capg_Product> findAllProductsByPriceAsc();
	
	@Query("from Capg_Product ORDER BY price DESC")
	public List<Capg_Product> findAllProductsByPriceDesc();
	
	@Query("from Capg_Product ORDER BY id DESC")
	public List<Capg_Product> findAllProductsByNewest();
	
	@Query("from Capg_Product where price>=999")
	public List<Capg_Product> findAllProductsByPrice();
}
