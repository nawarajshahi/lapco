package com.nawarajshahi.firstSpringBoot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nawarajshahi.firstSpringBoot.dto.RestroomDto;
import com.nawarajshahi.firstSpringBoot.entity.Address;
import com.nawarajshahi.firstSpringBoot.entity.Restroom;
import com.nawarajshahi.firstSpringBoot.service.impl.RestroomServiceImpl;

@RestController
public class RestroomController {
	
	@Autowired
	RestroomServiceImpl restroomServiceImpl;
	
	@PostMapping("/saveRestroom")
	public void saveRestroom(@RequestBody RestroomDto restroomDto) {
		Restroom restroom = new Restroom();
		Address address = new Address();
		
		address.setStreet(restroomDto.getStreet());
		address.setCity(restroomDto.getCity());
		address.setState(restroomDto.getState());
		address.setZipcode(restroomDto.getZipcode());
		
		restroom.setModel_no(restroomDto.getModel_no());
		restroom.setSerial_no(restroomDto.getSerial_no());
		restroom.setDate_installed(restroomDto.getDate_installed());
		restroom.setTotal_cost_of_installation(restroomDto.getTotal_cost_of_installation());
		restroom.setTotal_cost_of_production(restroomDto.getTotal_cost_of_production());
		
		restroom.setAddress(address);
		
		
		restroomServiceImpl.saveRestroom(restroom);
		
	}
	
	@GetMapping("/getRestroom/{restroom_id}")
	public Restroom getRestroomById(@PathVariable("restroom_id") Integer restroom_id) {
		return restroomServiceImpl.getRestroomById(restroom_id);
	}
	
	
	/**
	 * A method that will return solar panels that are associated with the given restroom_id
	 * NOTE: a restroom can have multiple solar reads and also a solar_read can provide power to multiple restrooms
	 */

}
