package com.dynamodemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dynamodemo.model.PetTracker;
import com.dynamodemo.repository.PagablePetTrackerRepo;

@RestController
public class PetTrackerController {

	@Autowired
	PagablePetTrackerRepo petTrackerRepo;
	
	
	@RequestMapping("/getPetTrackingDetails/{petId}")
	public List<PetTracker> getPetTrackerDetails(@PathVariable String petId){
		return petTrackerRepo.findByPetId(petId);
	}
	
	@RequestMapping("/setPetTrackingDetails")
	public void trackPetDetails(@RequestBody PetTracker petTracker){
		petTrackerRepo.save(petTracker);
	}
	
}
