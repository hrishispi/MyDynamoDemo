package com.dynamodemo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class YelpBusiness {
	private List<YelpRestaurant> businesses;

	public List<YelpRestaurant> getBusinesses() {
		return businesses;
	}

	public void setBusinesses(List<YelpRestaurant> businesses) {
		this.businesses = businesses;
	}
}
