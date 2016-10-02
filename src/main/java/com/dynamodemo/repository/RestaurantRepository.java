package com.dynamodemo.repository;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.dynamodemo.model.Restaurant;

@EnableScan
public interface RestaurantRepository extends CrudRepository<Restaurant, String>{
	public List<Restaurant> findById(@Param("id") String id);
}
