package com.dynamodemo.controller;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import javax.websocket.server.PathParam;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.dynamodemo.model.Pet;
import com.dynamodemo.model.Restaurant;
import com.dynamodemo.model.YelpBusiness;
import com.dynamodemo.model.YelpRestaurant;
import com.dynamodemo.repository.PagableRestaurantRepo;
import com.dynamodemo.repository.RestaurantRepository;
import com.dynamodemo.service.SnsService;

@RestController
public class RestaurantController {

	@Autowired
	PagableRestaurantRepo repository;
	
	@Autowired
	SnsService snsservice;
	
	@Autowired
	RestaurantRepository restaurantrepo;
	
    @Value("${yelp.bearer}")
    private String yelpBearer;
    
    @Value("${verify.pet.url}")
    private String verifyUrl;
	
	@RequestMapping("/getRestaurant/{retaurantId}")
	public List<Restaurant> getRestaurant(@PathVariable String retaurantId){
		return restaurantrepo.findById(retaurantId);
		
	}
	@RequestMapping("/getAllRestaurants")
	public List<Restaurant> getRestaurant(){
		return repository.findAll();
	}
/*	@RequestMapping("/createRestaurant")
	public void createRestaurant(@RequestParam String name,@RequestParam String contact){
		Restaurant restaurant = new Restaurant();
		restaurant.setName(name);
		restaurant.setContact(contact);
		if(StringUtils.isNotBlank(name) && StringUtils.isNotBlank(contact)){
			repository.save(restaurant);
		}
	}*/
	
	
/*	@RequestMapping("/extract/{city}")
	public List<YelpRestaurant> extractAndStore(@PathVariable String city){
		RestTemplate template = new RestTemplate();
		HttpHeaders headers =  new HttpHeaders();
		headers.add("Authorization", "Bearer "+yelpBearer);
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		String encodedCity = URLEncoder.encode(city);
		String yelpUrl = "https://api.yelp.com/v3/businesses/search?term=restaurant&location="+encodedCity;
		ResponseEntity<YelpBusiness> restaurantEntity=template.exchange(yelpUrl, HttpMethod.GET, entity, YelpBusiness.class);
		store(restaurantEntity.getBody().getBusinesses());
		System.out.println("Size is "+restaurantEntity.getBody().getBusinesses().size());
		return restaurantEntity.getBody().getBusinesses();
	}
	private void store(List<YelpRestaurant> businesses) {
		
		for (YelpRestaurant yelpRestaurant : businesses) {
			Restaurant restaurant = new Restaurant();
			restaurant.setName(yelpRestaurant.getName());
			restaurant.setLocation(yelpRestaurant.getLocation());
			restaurant.setCoordinates(yelpRestaurant.getCordinates());
			restaurant.setContact(yelpRestaurant.getPhone());
			repository.save(restaurant);
		}
		
	}*/
	@RequestMapping("/sendMessageByName/{name}")
	public String sendMessageByName(@PathVariable String name){
		List<Restaurant> restaurantList = restaurantrepo.findByName(name);
		String id=restaurantList.get(0).getId();
	    String message = verifyUrl+"?restId="+id;
	    String phoneNumber = restaurantList.get(0).getContact();
	    return snsservice.sendMessage(message, phoneNumber);
	}
	
	@RequestMapping(path="/verifyPet",method=RequestMethod.POST)
	public void createRestaurant(@RequestBody PetDetailsModel model){

		if(StringUtils.isNotBlank(model.getRestaurantId())){
			Restaurant restaurant = restaurantrepo.findOne(model.getRestaurantId());
			if(restaurant==null)throw new RuntimeException("restaurant id is empty");
			Pet pet = new Pet();
			pet.setCost(model.getCost());
			pet.setNosOfPetsAllowed(model.getNosOfPetsAllowed());
			pet.setVerified("Y");
			pet.setComments(model.getComments());
			restaurant.setPet(pet);
			repository.save(restaurant);
			return;
		}
		throw new RuntimeException("restaurant id is empty");
	}

	
}
