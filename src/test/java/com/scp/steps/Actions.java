package com.scp.steps;
import com.scp.library.Request;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;

public class Actions {
	
	private static ResponseOptions<Response> response;

	public static ResponseOptions<Response> performGet() {
		
		response = Request.getCallSetupWithPathParam().get().then().extract().response();
		return response;
	  
	}
	
	public static ResponseOptions<Response> performPost(){
       
	   response = Request.postCallSetup().post().then().extract().response();
	   return  response;
  
    } 

}
