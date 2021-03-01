package com.nawarajshahi.firstSpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nawarajshahi.firstSpringBoot.service.impl.DoorSensorServiceImpl;

@RestController
public class DoorSensorController {
	
	@Autowired
	DoorSensorServiceImpl doorServiceImpl;
	
	@GetMapping("/{restroom_id}/getDoorReads")
	public ResponseEntity<?> getDoorReadsByRestroomId(@PathVariable("restroom_id") Integer restroom_id){
		
		return null;
	}

}
