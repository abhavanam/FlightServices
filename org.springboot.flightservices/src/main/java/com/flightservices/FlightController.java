package com.flightservices;

import java.util.List;

import org.apache.tomcat.util.json.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;





/**
 * A controller handling requests for CRUD operations on Flight services.
 */
@RestController
public class FlightController {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	private FlightService flightService;

	
	
	@Autowired
	public FlightController(FlightService flightService) {
		this.flightService = flightService;
	}

	
	/**
	 * Provide a list of all flights.
	 */
	@GetMapping(value = "/flights")
	public @ResponseBody List<Flight> flightDetails() {
		return App.flightServices;
	}
	
	/**
	 * To load the flights based on the search results
	 * @param flightNumber
	 * @param origin
	 * @param destination
	 * @param date
	 * @return
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value = "/flights/{flightNumber}/origin/{origin}/destination/{destination}/date/{date}")
	public @ResponseBody Object flightDetails(
			@PathVariable("flightNumber") String flightNumber,
			@PathVariable("origin") String origin,
			@PathVariable("destination") String destination,
			@PathVariable("date") String date)  {
		logger.info(flightNumber +"-"+origin+"-"+destination+"-"+date);
		List<Flight> services = null;
		APIError apiError  = null;
		try {
			services = flightService.search(flightNumber, origin, destination, date, App.flightServices);
		} catch (Exception e) {
			apiError = new APIError(HttpStatus.BAD_REQUEST.value(),"Bad Request",e.toString(),e.getMessage());
			return apiError;
		}
		if(services.size() == 0) {
			return "Change the search parameters to retrive the results";
		}
		
		return services;
	}

}
