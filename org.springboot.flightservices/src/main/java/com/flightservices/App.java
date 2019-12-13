package com.flightservices;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;



@SpringBootApplication
public class App implements CommandLineRunner  {
	
	public static List<Flight> flightServices;

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	@Override
    public void run(String[] args) {
			// read json and write to db
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Flight>> typeReference = new TypeReference<List<Flight>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/flightdata.json");
			try {
				flightServices = mapper.readValue(inputStream,typeReference);
				System.out.println(flightServices);
				System.out.println("loaded flight services ::: " + flightServices.size());
			}catch (IOException e){
				System.out.println("Unable to load flight services data: " + e.getMessage());
			}
		}
		
}