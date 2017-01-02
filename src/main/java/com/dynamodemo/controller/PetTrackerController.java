package com.dynamodemo.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.dynamodemo.config.FindMyPetMarshaller;
import com.dynamodemo.model.FindMyPetId;
import com.dynamodemo.model.PetTracker;
import com.dynamodemo.repository.PagablePetTrackerRepo;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class PetTrackerController {

	@Autowired
	PagablePetTrackerRepo petTrackerRepo;
	
	
	@RequestMapping("/getPetTrackingDetails/{petId}")
	public List<PetTracker> getPetTrackerDetails(@PathVariable String petId){
		List<PetTracker> petTracker = petTrackerRepo.findByPetIdOrderByDateReportedDesc(petId);
		return petTracker;
	}
//9898 9000	
	@RequestMapping("/setPetTrackingDetails")
	public void trackPetDetails(@RequestBody PetTracker petTracker){
		RestTemplate restTemplate = new RestTemplate();
		try{
		String petIdObject = restTemplate.getForObject("http://Roaming-Tails-ELB-1400615914.us-east-1.elb.amazonaws.com:8080/beacon/getPetId/"+petTracker.getMajorId()+"/"+petTracker.getMinorId(), String.class);
		JSONObject jsonObject = new JSONObject(petIdObject);
		String petId = (String) jsonObject.get("petId");
		petTracker.setPetId(petId);
		DateFormat dateFormat = FindMyPetMarshaller.getDateFormat();
		Date date = new Date();
		dateFormat.setTimeZone(TimeZone.getTimeZone("America/New_York"));
		String insertDate = dateFormat.format(date); //2016/11/16 12:08:43
		Date formattedDate = new Date(insertDate);
		petTracker.setDateReported(formattedDate);
		FindMyPetId compositeKey = new FindMyPetId();
		compositeKey.setInsertDate(formattedDate);
		compositeKey.setPetId(petId);
		petTracker.setId(compositeKey);
		}
		catch (Exception e) {
			System.out.println("Looks like service is down or petid was not found");
			e.printStackTrace();
			petTracker.setPetId("99999");
		}
		petTrackerRepo.save(petTracker);
	}
	
}
