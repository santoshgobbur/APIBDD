package com.scp.library;

import java.io.File;

import com.scp.library.Payload;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.scp.testdata.CreateProductPayload;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Request {
	
	private static RequestSpecification requestSpec;
	private static RequestSpecification Request;
	private static ResponseSpecification responseSpec;
	
	public static RequestSpecification getCallSetupWithPathParam() {

		RequestSpecBuilder builder = new RequestSpecBuilder();
		builder.setBaseUri("http://localhost:3030/products");
		//builder.addPathParam("/products", builder);
		builder.setContentType(ContentType.JSON);
		requestSpec = builder.build();
		Request = RestAssured.given().spec(requestSpec);
		return Request;
	}
	
	public static RequestSpecification postCallSetup() {
		
		RequestSpecBuilder builder = new RequestSpecBuilder();
		builder.setBaseUri("http://localhost:3030/products");
		builder.setContentType(ContentType.JSON);
		//builder.setBody(CreateProductPayload,mapper);
	    builder.setBody(Payload.getPayloadObjectMapper());
	    requestSpec = builder.build();
		Request = RestAssured.given().spec(requestSpec);
		return Request;
		
	}
	
    public static ResponseSpecification responsSpec() {
		
    	responseSpec= new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
		return responseSpec;	
	}



}

