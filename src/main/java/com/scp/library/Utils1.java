package com.scp.library;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.scp.testdata.CreateProductPayload;

import cucumber.api.DataTable;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utils1 {
	
	public static RequestSpecification request;
	public static ResponseSpecification responseSpec;
	public static ObjectMapper mapper;
	private static String payloaddata;


	public static RequestSpecification requestGetSpecification(){
		
		request = new RequestSpecBuilder().setBaseUri("http://localhost:3030/products").build();
		return request;
	}
	
    public static ResponseSpecification responsSpec() {
		
    	responseSpec= new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
		return responseSpec;	
	}

    
//    public static RequestSpecification requestPostSpecification() throws JsonGenerationException, JsonMappingException, IOException {
//		
//    	request = new RequestSpecBuilder().setBaseUri("http://localhost:3030/products").setContentType(ContentType.JSON).setBody(Utils.getPayload()).build();
//		return request;
//		
//	}
    
 /*   public static RequestSpecification getPayloadWithJavaObject() throws JsonGenerationException, JsonMappingException, IOException{
    	
    	CreateProductPayload payload = new CreateProductPayload("mobile","Smartphone",1500,1,"Mas","Midrange","India","Note","amazon.com","Blue");
    	mapper = new ObjectMapper();
        mapper.writeValue(new File("Resources/Payload.json"),payload);
        payloaddata = mapper.writeValueAsString(payload);
    	
      request = new RequestSpecBuilder().setBaseUri("http://localhost:3030/products").setContentType(ContentType.JSON).setBody(payload).build();
    	return request;
        return payloaddata;
        	
    } */
    
      public static String getPayloadWithJavaObject() {
    	
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
    
//  public static RequestSpecification requestPostSpecification() throws JsonGenerationException, JsonMappingException, IOException {
//		
//  	request = new RequestSpecBuilder().setBaseUri("http://localhost:3030/products").setContentType(ContentType.JSON).setBody(payload);
//	return request;
//		
//	}

}

