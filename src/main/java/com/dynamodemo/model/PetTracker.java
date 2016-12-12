package com.dynamodemo.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName="PetTracker")
public class PetTracker {
	
	private Cordinates coordinates;
	
	private String id;
	
	private String petId;
	
	private String majorId;
	
	private String minorId;
	
	private String reportedUserId;

	@DynamoDBAttribute
	public String getPetId() {
		return petId;
	}

	public void setPetId(String petId) {
		this.petId = petId;
	}
	
	public Cordinates getCoordinates() {
		return coordinates;
	}

	@DynamoDBHashKey
	@DynamoDBAutoGeneratedKey 
	public String getId() {
		return id;
	}

	@DynamoDBAttribute
	public String getMajorId() {
		return majorId;
	}

	public void setMajorId(String majorId) {
		this.majorId = majorId;
	}

	@DynamoDBAttribute
	public String getMinorId() {
		return minorId;
	}

	public void setMinorId(String minorId) {
		this.minorId = minorId;
	}

	@DynamoDBAttribute
	public String getReportedUserId() {
		return reportedUserId;
	}

	public void setReportedUserId(String reportedUserId) {
		this.reportedUserId = reportedUserId;
	}

	public void setCoordinates(Cordinates coordinates) {
		this.coordinates = coordinates;
	}

	public void setId(String id) {
		this.id = id;
	}

}