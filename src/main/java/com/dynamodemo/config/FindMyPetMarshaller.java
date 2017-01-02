package com.dynamodemo.config;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMarshaller;
import com.dynamodemo.model.FindMyPetId;

public class FindMyPetMarshaller implements DynamoDBMarshaller<FindMyPetId>{

	@Override
	public String marshall(FindMyPetId arg0) {
		// TODO Auto-generated method stub
		return arg0.getPetId()+"--"+arg0.getInsertDate();
	}

	@Override
	public FindMyPetId unmarshall(Class<FindMyPetId> arg0, String arg1) {
		FindMyPetId petId = new FindMyPetId();
		String[] petDate = arg1.split("--");
		petId.setPetId(petDate[0]);
		petId.setInsertDate(new Date(petDate[1]));
		return petId;
	}

	public static DateFormat getDateFormat() {
		return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	}

}
