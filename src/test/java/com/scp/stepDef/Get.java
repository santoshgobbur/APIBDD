package com.scp.stepDef;

import java.util.List;
import java.util.concurrent.SynchronousQueue;

import com.scp.steps.Actions;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.equalTo;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;
import io.restassured.response.ResponseOptions;
import junit.framework.Assert;

public class Get  {
	
	public static ResponseOptions<Response>response;
	
	@When("^user perform GET$")
	public void user_perform_GET() throws Throwable {
	   		
		 response  = Actions.performGet();
	
	}

	@Then("^user verify get call success with status code (\\d+)$")
	public void user_verify_get_call_success_with_status_code(int arg1) throws Throwable {
	 
	  Assert.assertEquals(arg1,response.getStatusCode());
	  
	  assertThat(response.getBody().jsonPath().getInt("total"),equalTo(51989));
	  
//		int a = arg1;
//		int b = response.getStatusCode();
//		assertThat(a,equalTo(b));
	      
	}
	@Then("^user verify limit is (\\d+)$")
	public void user_verify_limit_is(int expectedValue) throws Throwable {
      
		Assert.assertEquals(expectedValue,response.getBody().jsonPath().getInt("limit"));
	}

	@Then("^user verify data has (\\d+) elements$")
	public void user_verify_data_has_elements(int arg1) throws Throwable {
	  
		List<Object> dataArr = response.getBody().jsonPath().getList("data");
		Assert.assertEquals(10,dataArr.size());
	}
	
	@Then("^user verify below$")
	public void user_verify_below(DataTable table){
		
		List<List<String>> i = table.raw();	
		
//		System.out.println(i.get(0).get(1));
//		System.out.println(i.get(1).get(1));
		
		System.out.println(i.size());
		
		Assert.assertEquals(i.get(0).get(1),response.getBody().jsonPath().get("data[0].categories[0].id"));
		Assert.assertEquals(i.get(0).get(2),response.getBody().jsonPath().get("data[0].categories[1].id"));
		Assert.assertEquals(i.get(0).get(3),response.getBody().jsonPath().get("data[0].categories[2].id"));
		Assert.assertEquals(i.get(0).get(4),response.getBody().jsonPath().get("data[0].categories[3].id"));
		Assert.assertEquals(i.get(1).get(1),response.getBody().jsonPath().get("data[0].categories[0].name"));
		Assert.assertEquals(i.get(1).get(2),response.getBody().jsonPath().get("data[0].categories[1].name"));
		Assert.assertEquals(i.get(1).get(3),response.getBody().jsonPath().get("data[0].categories[2].name"));
		Assert.assertEquals(i.get(1).get(4),response.getBody().jsonPath().get("data[0].categories[3].name"));
		Assert.assertEquals(i.get(2).get(1),response.getBody().jsonPath().get("data[0].categories[0].createdAt"));
		Assert.assertEquals(i.get(2).get(2),response.getBody().jsonPath().get("data[0].categories[1].createdAt"));
		Assert.assertEquals(i.get(2).get(3),response.getBody().jsonPath().get("data[0].categories[2].createdAt"));
		Assert.assertEquals(i.get(2).get(4),response.getBody().jsonPath().get("data[0].categories[3].createdAt"));
		Assert.assertEquals(i.get(3).get(1),response.getBody().jsonPath().get("data[0].categories[0].updatedAt"));
		Assert.assertEquals(i.get(3).get(2),response.getBody().jsonPath().get("data[0].categories[1].updatedAt"));
		Assert.assertEquals(i.get(3).get(3),response.getBody().jsonPath().get("data[0].categories[2].updatedAt"));
		Assert.assertEquals(i.get(3).get(4),((ResponseBodyExtractionOptions) response.getBody()).jsonPath().get("data[0].categories[3].updatedAt"));
	}
	
	@And("^user gets the product id in console$")
	public void user_gets_the_product_id(){

        int productId = response.getBody().jsonPath().getInt("id");
        
        System.out.println(productId);
	}
	


	
	
}
