package com.scp.steps;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.scp.library.Utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Actions {
	
	private static Response response;

	public static Response performGet() {
		
		response = given().spec(Utils.requestGetSpecification()).when().get().then().extract().response();
		return response;
	  
	}
	
   public static ResponseSpecification validateContentType() {
	   
	   return Utils.responsSpec();
	   
   }
   
   public static List<Object> validateMultipleData(Response response) {
	   
	   List<Object> dataids = response.getBody().jsonPath().getList("data.id");
	   return dataids;
	   
   }
   
//   public static Response performPost() throws JsonGenerationException, JsonMappingException, IOException {
//	    
//	   response = given().spec(Utils.requestPostSpecification()).when().post().then().extract().response();
//	   return  response;
//   }
   
// public static Response performPost() throws JsonGenerationException, JsonMappingException, IOException {
//   
//  response = given().spec(Utils.getPayloadWithJavaObject()).when().post().then().extract().response();
//  return  response;
//}
   
  
}
