package Utils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.scp.library.Utils;
import com.scp.library.Utils1;

import cucumber.api.DataTable;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class RestAssuerdBase extends Utils {
	
	 
//	public static RequestSpecification requestSpec;
//	public static RequestSpecification requestSpecWithPayload;
//	public static RequestSpecification requestSpecwithParams;
//	public static Response response;
//	public static HashMap<String,String> queryParam;
//	public static List<List<String>> bodyParams;
//	public static DataTable table1;
	
	public static RequestSpecification requestspec;
	public static RequestSpecification Request;
	
	public static ResponseOptions<Response> response;
	
	public RestAssuerdBase() {
		
		RequestSpecBuilder builder = new RequestSpecBuilder();
		builder.setBaseUri("http://localhost:3030");
		builder.addParam("/products");
		builder.setContentType(ContentType.JSON);
	    builder.setBody(Utils1.getPayloadWithJavaObject());
		requestspec = builder.build();
		Request = RestAssured.given().spec(requestspec);
	/*	
		requestSpec = new RequestSpecBuilder().setBaseUri("http://localhost:3030/products").build();
		requestSpecwithParams = new RequestSpecBuilder().setBaseUri("http://localhost:3030/stores").build();
	    requestSpecWithPayload =  new RequestSpecBuilder().setBaseUri("http://localhost:3030/products").setContentType(ContentType.JSON).setBody(Utils.getPayloadWithJavaObject()).build();
   */

	}
	public static ResponseOptions<Response> Get(String url){
		
//		response = RestAssured.given().spec(requestSpec).when().get().then().extract().response();
//		return response;
		
		response  = Request.get(url);
		return response ;
		
	} 
	
	public static ResponseOptions<Response> PostWithBody(String url) {
		
		response  = Request.post(url);
		return response;
		
	} 
	
	
	/*public static Response GetWithQueryParameters(HashMap<String,String> queryParam){
		
		response = RestAssured.given().spec(requestSpecwithParams).queryParams(queryParam).when().get().then().extract().response();
		return response;
		
	} */
	
	/* public static Response postCall(){
		  
		//response = requestSpecWithPayload.when().post().then().extract().response(); 
		response = RestAssured.given().spec(requestSpecWithPayload).when().post().then().extract().response();
		return response;
			
	} */
	
	
}
