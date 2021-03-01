package com.nawarajshahi.firstSpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nawarajshahi.firstSpringBoot.entity.Restroom;

@Repository
public interface RestroomRepository extends JpaRepository<Restroom, Integer>{
	
}
