package Steps;

import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hamcrest.Matcher;
import org.testng.Assert;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

import Utils.RestAssuerdBase;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.ResponseSpecification;

public class Getstpes {

	private static ResponseOptions<Response> response;
	
	@When("^user perform get operation \"([^\"]*)\"$")
	public void user_perform_get_operation(String url){
	  
		//response = RestAssuerdBase.Get(url);
	}
	
	@Then("^user verify get api call with succcess code (\\d+)$")
	public void user_verify_get_api_call_with_succcess_code(int expectedStatusCode){

		Assert.assertEquals(response.getStatusCode(),expectedStatusCode);
		
	}
	
	@Then("^user verify limit is (\\d+)$")
	public void user_verify_total_is(int expectedtotalValue){

		Assert.assertEquals(response.getBody().jsonPath().getInt("limit"),expectedtotalValue);

	}
		
		@Then("^user verify categories id value$")
		public void user_verify_categories_id_value(DataTable table){
	
		
			List<List<String>> id = table.raw();
		
			List<String> str1 = new ArrayList<String>();
			List<String> str2 = new ArrayList<String>();
			
			str1.add(id.get(1).get(0));
			str1.add(id.get(2).get(0));
			str1.add(id.get(3).get(0));
			str1.add(id.get(4).get(0));
			str2.add(id.get(5).get(0));
			str2.add(id.get(6).get(0));
			str2.add(id.get(7).get(0));
			str2.add(id.get(8).get(0));
			//System.out.println(str);
			
			//List<String> ids = response.getBody().jsonPath().getList("data[0].categories.id");
			
			List<List<String>> ids = response.getBody().jsonPath().getList("data.categories.id");
			
//			for(int i=0;i<=ids.size();i++) {
//				
//				Assert.assertEquals(ids.get(6));
//				
//			}
//			System.out.println(ids.size());
//			System.out.println(ids.get(0));
			
			//System.out.println(ids);
			//Assert.assertEquals(ids,str);
		   
		
		}
		
	
	
	private Matcher<? super List<String>> is(List<String> str) {
			// TODO Auto-generated method stub
			return null;
		}

	@When("^user perform post operation for \"([^\"]*)\" with payload data as json file$")
	public void user_perform_post_operation_for_with_payload_data_as_json_file(String url) {
		
		response = RestAssuerdBase.PostWithBody(url);
	 
	}

	
	@Then("^user verify post api call with succcess code (\\d+)$")
	public void user_verify_post_api_call_with_succcess_code(int expectedStatusCode) {
        
		Assert.assertEquals(response.getStatusCode(),expectedStatusCode);
	}
	
	
//	@When("^user perform post operation for \"([^\"]*)\" with body$")
//	public void user_perform_post_operation_for_with_body(String url, DataTable table){
//		
//		List<List<String>> data = table.raw();
//		
//		HashMap<String,Object> body = new HashMap<String, Object>();
//		body.put("name", data.get(1).get(0));
//		body.put("type", data.get(1).get(1));
//		body.put("price", data.get(1).get(2));
//		body.put("shipping", data.get(1).get(3));
//		body.put("upc", data.get(1).get(4));
//		body.put("description", data.get(1).get(5));
//		body.put("manufacturer", data.get(1).get(6));
//		body.put("model", data.get(1).get(7));
//		body.put("url", data.get(1).get(8));
//		body.put("image", data.get(1).get(9));
//		
//		response = RestAssuerdBase.PostWithBody(url,body);
//		
//		System.out.println(response.getStatusCode());
//	   
//	}
	
	
}
