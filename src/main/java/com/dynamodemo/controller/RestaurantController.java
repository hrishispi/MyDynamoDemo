package com.dynamodemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dynamodemo.model.Restaurant;
import com.dynamodemo.repository.PagableRestaurantRepo;
import com.dynamodemo.repository.RestaurantRepository;

@RestController
public class RestaurantController {

	@Autowired
	PagableRestaurantRepo repository;
	
	@Autowired
	RestaurantRepository restaurantrepo;
	
	@RequestMapping("/getRestaurant/{retaurantId}")
	public List<Restaurant> getRestaurant(@PathVariable String retaurantId){
		return restaurantrepo.findById(retaurantId);
		
	}
	@RequestMapping("/getAllRestaurants")
	public List<Restaurant> getRestaurant(){
		return repository.findAll();
	}
}
