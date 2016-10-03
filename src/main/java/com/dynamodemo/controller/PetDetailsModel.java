package com.dynamodemo.controller;

public class PetDetailsModel {
	private String restaurantId;
	private String petAllowed;
	private int nosOfPetsAllowed;
	private int cost;
	private String comments;
	
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(String restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getPetAllowed() {
		return petAllowed;
	}
	public void setPetAllowed(String petAllowed) {
		this.petAllowed = petAllowed;
	}
	public int getNosOfPetsAllowed() {
		return nosOfPetsAllowed;
	}
	public void setNosOfPetsAllowed(int nosOfPetsAllowed) {
		this.nosOfPetsAllowed = nosOfPetsAllowed;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	
}
