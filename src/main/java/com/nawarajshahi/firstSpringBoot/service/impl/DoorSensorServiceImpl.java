package com.nawarajshahi.firstSpringBoot.service.impl;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nawarajshahi.firstSpringBoot.entity.DoorSensor;
import com.nawarajshahi.firstSpringBoot.entity.Restroom;
import com.nawarajshahi.firstSpringBoot.repository.DoorSensorRepository;
import com.nawarajshahi.firstSpringBoot.repository.RestroomRepository;
import com.nawarajshahi.firstSpringBoot.service.DoorSensorService;

@Service
public class DoorSensorServiceImpl implements DoorSensorService, Serializable {

	/**
	 * serialVersionUID = -4927352927620864449L
	 */
	private static final long serialVersionUID = -4927352927620864449L;

	private static final Logger logger = LogManager.getLogger(DoorSensorServiceImpl.class);

    @Autowired private DoorSensorRepository doorRepo;

    @Autowired private RestroomRepository restRepo;

    //create door sensor read for specific restroom
    public DoorSensor createDoorRead(Integer rest_id, DoorSensor doorSensor){
        //get the restroom with given rest_id
        Restroom restroom = restRepo.getOne(rest_id);
        try{
            if(restroom != null){
                logger.info("Restroom exists, and setting restroom details to the door sensor.");
                doorSensor.setRestroom(restroom);
                doorSensor.setDoorOpenTime(LocalDateTime.now());
                doorSensor.setDoorCloseTime(LocalDateTime.now().plusSeconds(8)); //door closes after 8 seconds.
                doorSensor.setMessage("Door opened & closed.");
                logger.info("Created door sensor read details.");
                return doorRepo.save(doorSensor);
            }
            logger.error("restroom does not exist, returning null");
            return null;
        }catch (Exception e){
            logger.error("Error occurred while creating door read details.");
            throw e;
        }
    }

    //read all the door sensor data for given restroom_id
    public List<DoorSensor> getDoorReadsByRestroomId(Integer rest_id){
        //first obtain the restroom with given rest_id
        Restroom restroom = restRepo.getOne(rest_id);
        try{
            if(restroom !=null){
                logger.info("Restroom exits, returning door read details with restroom id: " + rest_id);
                List<DoorSensor> doorSensors = new ArrayList<>();

                Iterable<DoorSensor> doorSensorIterable = doorRepo.findAll();
                for(DoorSensor sensor: doorSensorIterable){
                    if(sensor.getRestroom().getRestroom_id()== rest_id){
                        doorSensors.add(sensor); //add only if restroom_id matches
                    }
                }
                logger.info("Successfully retrieved door read details with restroom id: " + rest_id);
                return doorSensors;
            }
            logger.error("Restroom doesn't exist, returning null");
            return null;
        }catch (Exception e){
            logger.error("Error retrieving door read details, please make sure details are correct.");
            throw e;
        }
    }

	
}
