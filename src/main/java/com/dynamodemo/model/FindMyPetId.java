package com.dynamodemo.model;

import java.io.Serializable;
import java.util.Date;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;

public class FindMyPetId implements Serializable{

	private String petId;
	
	private Date insertDate;

	@DynamoDBHashKey
	public String getPetId() {
		return petId;
	}

	public void setPetId(String petId) {
		this.petId = petId;
	}

	@DynamoDBRangeKey
	public Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}
}
