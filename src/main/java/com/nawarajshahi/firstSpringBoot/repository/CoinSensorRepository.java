package com.nawarajshahi.firstSpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nawarajshahi.firstSpringBoot.entity.CoinSensor;



public interface CoinSensorRepository extends JpaRepository<CoinSensor, Integer> {

}
