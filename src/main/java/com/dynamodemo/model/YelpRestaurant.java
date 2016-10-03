package com.dynamodemo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class YelpRestaurant {
	private Cordinates coordinates;
	private Location location;
	private String name;
	private String phone;
	public Cordinates getCordinates() {
		return coordinates;
	}
	public Location getLocation() {
		return location;
	}
	public String getName() {
		return name;
	}
	public String getPhone() {
		return phone;
	}
	public void setCordinates(Cordinates coordinates) {
		this.coordinates = coordinates;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
