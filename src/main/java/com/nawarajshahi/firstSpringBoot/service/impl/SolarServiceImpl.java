package com.nawarajshahi.firstSpringBoot.service.impl;

import java.io.Serializable;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nawarajshahi.firstSpringBoot.entity.Restroom;
import com.nawarajshahi.firstSpringBoot.entity.Solar;
import com.nawarajshahi.firstSpringBoot.repository.RestroomRepository;
import com.nawarajshahi.firstSpringBoot.repository.SolarRepository;
import com.nawarajshahi.firstSpringBoot.service.SolarService;

@Service
public class SolarServiceImpl implements SolarService, Serializable {

	/**
	 * serialVersionUID = -3292025697554152010L
	 */
	private static final long serialVersionUID = -3292025697554152010L;

	 private static final Logger logger = LogManager.getLogger(SolarServiceImpl.class);
	 
	@Autowired
    private SolarRepository solarRepo;

    @Autowired
    private RestroomRepository restRepo;

    
    //create solar read by restroom_id
    @Override
    public Solar createSolarRead(Integer rest_id, Solar solar) throws Exception {
        //check to see if restroom exists
        Restroom restroom = restRepo.getOne(rest_id);
        try{
            if(restroom != null){
                logger.info("Restroom exists, and setting restroom details to the solar sensor.");
                double lowerLimit = 20;
                double upperLimit = 200D;
                double quantity = lowerLimit + new Random().nextDouble() * (upperLimit - lowerLimit);
                solar.setGeneratedQty(quantity);
                solar.setMessage("panel active.");
                return solarRepo.save(solar);
            }
            logger.error("restroom does not exist, returning null");
            throw new Exception("Restroom doesn't exist, returning null.");
        }catch(Exception e){
            logger.error("Error creating solar read");
            throw e;
        }
    }
}
