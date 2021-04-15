package com.scp.library;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.scp.testdata.CreateProductPayload;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Payload {
	
	public static RequestSpecification request;
	public static ResponseSpecification responseSpec;
	public static ObjectMapper mapper;
	private static String payloaddata;

	 public static String getPayloadObjectMapper() {
	    	
	    	CreateProductPayload payload = new CreateProductPayload("molewa","tphoasdasdne",100,1,"Mas","Midrange","India","Note","amazon.com","Blue");
	    	mapper = new ObjectMapper();
	        try {
				mapper.writeValue(new File("Resources/Payload.json"),payload);
			} catch (JsonGenerationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        try {
				payloaddata = mapper.writeValueAsString(payload);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        return payloaddata;
	        
	    	
	    }
	    

}
