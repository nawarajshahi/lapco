package com.nawarajshahi.firstSpringBoot.repository;

import org.springframework.data.repository.CrudRepository;

import com.nawarajshahi.firstSpringBoot.entity.DoorSensor;

import java.util.List;

public interface DoorSensorRepository extends CrudRepository<DoorSensor, Integer> {



}
