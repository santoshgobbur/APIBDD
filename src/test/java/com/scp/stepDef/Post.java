package com.scp.stepDef;

import org.testng.Assert;

import com.scp.steps.Actions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;

public class Post {
	
	private static ResponseOptions<Response> response ;
	
	@When("^user perform post$")
	public void user_perform_post(){

		response = Actions.performPost();
		
	}

	@Then("^user verify post api call with succcess code (\\d+)$")
	public void user_verify_post_api_call_with_succcess_code(int expectedStatusCode){
		
		Assert.assertEquals(expectedStatusCode,response.getStatusCode());
		System.out.println(response.getBody().jsonPath().getInt("id"));

	}

}
