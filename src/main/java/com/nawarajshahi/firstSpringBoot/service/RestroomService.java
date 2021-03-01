package com.nawarajshahi.firstSpringBoot.service;

import java.io.Serializable;


import com.nawarajshahi.firstSpringBoot.entity.Restroom;


public interface RestroomService extends Serializable{
	
	public boolean saveRestroom(Restroom restroom);
	
	
}
