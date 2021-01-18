package com.scp.bddstyle;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Steps {
	
	public static RequestSpecification req;
	public static ResponseSpecification res;
	public static Response r;

	public static Response getCall() {

		RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
		reqBuilder.setBaseUri("http://localhost:3030/products");
		reqBuilder.setAccept(ContentType.JSON);
		reqBuilder.build();
		
		RequestSpecification req = RestAssured.given();
		Response r = given().spec(req).when().get();
		return r;
		  
	}
	
	public static ResponseSpecification validate(Response r) {
		
		ResponseSpecification res = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		return res;
		
		
	}


}

