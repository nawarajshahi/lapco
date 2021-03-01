package com.nawarajshahi.firstSpringBoot.service.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nawarajshahi.firstSpringBoot.entity.Restroom;
import com.nawarajshahi.firstSpringBoot.repository.AddressRepository;
import com.nawarajshahi.firstSpringBoot.repository.RestroomRepository;
import com.nawarajshahi.firstSpringBoot.service.RestroomService;

@Service
public class RestroomServiceImpl implements RestroomService, Serializable {

	/**
	 * serialVersionUID = -2026097534721892436L
	 */
	private static final long serialVersionUID = -2026097534721892436L;

	@Autowired
	RestroomRepository restroomRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	
	@Override
	public boolean saveRestroom(Restroom restroom) {
		
		addressRepository.save(restroom.getAddress());
		restroomRepository.save(restroom);
		
		return true;
		
	}


	
	public Restroom getRestroomById(Integer restroom_id) {
		Restroom restroom = restroomRepository.getOne(restroom_id);
//		System.out.println(restroom);
		if(restroom.equals(null)) {
			return null;
		}
		return restroom;
	}
	
	
}



/*
 * 1. CrudRepository
 * 2. Paging 
 * 
 * most advanced is: 
 * 3. JPARepository (provides complete abstraction, also includes methods in CrudRepository). 
 * In this, we can also customized fetching strategies. 
 */