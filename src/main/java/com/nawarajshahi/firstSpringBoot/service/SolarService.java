package com.nawarajshahi.firstSpringBoot.service;

import java.io.Serializable;

import com.nawarajshahi.firstSpringBoot.entity.Solar;

public interface SolarService extends Serializable{
	public Solar createSolarRead(Integer rest_id, Solar solar) throws Exception;
}
