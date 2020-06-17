package com.cg.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.entity.Coupon;

public interface CouponRepo extends JpaRepository<Coupon, Integer>{


	@Query("from Coupon where couId=:code")
	public Coupon getCouponByCustomId(@Param("code") int code);
}
