package com.flightservices;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class FlightService {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * @param flightNumber
	 * @param origin
	 * @param destination
	 * @param date
	 * @param flightServices
	 * @return
	 * @throws Exception
	 */
	public List<Flight> search(String flightNumber,String origin,String destination,String date,List<Flight> flightServices) throws Exception {
		
		logger.debug("Class Name ::" + getClass() + "   :: Method Name::  search started with parameters");
		
		if(StringUtils.isEmpty(date) || date.equalsIgnoreCase("null")) {
		    throw new Exception("Date cannot be null");
		}
		if((StringUtils.isEmpty(flightNumber) || flightNumber.equalsIgnoreCase("null")) || 
				((StringUtils.isEmpty(origin) || origin.equalsIgnoreCase("null")) && 
						(StringUtils.isEmpty(destination) || destination.equalsIgnoreCase("null")))) {
			throw new Exception("flightNumber OR (origin AND destination) cannot be null");
		}
		List<Flight> searchList = new ArrayList<Flight>();
		
		flightServices.forEach(flightservice ->{
			if((flightservice.getFlightNumber().equalsIgnoreCase(flightNumber) ||
					(flightservice.getOrigin().equalsIgnoreCase(origin) &&  flightservice.getDestination().equalsIgnoreCase(destination)))
					&& (flightservice.getDeparture().equalsIgnoreCase(date) || flightservice.getArrival().equalsIgnoreCase(date))){
				searchList.add(flightservice);
			}
		});
		logger.debug("No of Search list found::" +searchList.size());
		return searchList;
	}

}
