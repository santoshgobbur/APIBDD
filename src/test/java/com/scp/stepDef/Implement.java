package com.scp.stepDef;

import java.util.List;

import com.scp.steps.Actions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import junit.framework.Assert;

public class Implement  {
	
	private static Response response;
	
	@When("^user prform GET$")
	public void user_prform_GET() throws Throwable {
	   		
		 response  = Actions.performGet();
	
	}
	@Then("^user verify response body as json$")
	public void user_verify_response_body_as_json() throws Throwable {
	   
		Actions.validateContentType();
	   
	}
	@Then("^user verify get call success with status code (\\d+)$")
	public void user_verify_get_call_success_with_status_code(int arg1) throws Throwable {
	 
		Assert.assertEquals(arg1,response.getStatusCode());
          
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
//	@Then("^user verify post call success with status code (\\d+)$")
//	public void user_verify_post_call_success_with_status_code(int arg3) throws Throwable {
//	  
//		response = Actions.performPost();
//		Assert.assertEquals(arg3,response.getStatusCode());
//	}
	@And("^user gets the product id in console$")
	public void user_gets_the_product_id(){

        int productId = response.getBody().jsonPath().getInt("id");
        System.out.println(productId);
	}
	
	
//	@When("^user verify data \"([^\"]*)\"$")
//	public void user_verify_data(String arg1) throws Throwable {
//      
//		List<Object> dataids = response.getBody().jsonPath().getList("data.id");
//		int expected = Integer.parseInt(arg1);
//		Assert.assertEquals(expected,dataids.get(0));
//	}
//	@When("^user verify data \"([^\"]*)\"$")
//	public void user_verify_data(String arg1) throws Throwable {
//   
//		List<Object> dataids = Actions.validateMultipleData(response);
//		int expected = Integer.parseInt(arg1);
//		Assert.assertEquals(expected,dataids.get(0));
//	}
	
}
