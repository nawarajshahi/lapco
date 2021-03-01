package com.nawarajshahi.firstSpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nawarajshahi.firstSpringBoot.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{

}
