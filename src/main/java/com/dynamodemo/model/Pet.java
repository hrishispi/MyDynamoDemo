package com.dynamodemo.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

@DynamoDBDocument
public class Pet {
	private String petAllowed;
	private int nosOfPetsAllowed;
	private int cost;
	private String verified;
	private String comments;
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
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
	public String getVerified() {
		return verified;
	}
	public void setVerified(String verified) {
		this.verified = verified;
	}
	
}
