package Utils;

import java.util.HashMap;
import java.util.List;
import com.scp.library.Utils1;
import cucumber.api.DataTable;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;




public class RestAssuerdBase extends Utils1 {
	
	 
	public static RequestSpecification requestSpec;
	public static RequestSpecification requestSpecWithPayload;
	public static RequestSpecification requestSpecwithParams;
	public static HashMap<String,String> queryParam;
	public static List<List<String>> bodyParams;
	public static DataTable table1;
	
	public static RequestSpecification requestspec;
	public static RequestSpecification Request;
	
	public static ResponseOptions<Response> response;
	//public static Response response; 
	public RestAssuerdBase() {
		
		RequestSpecBuilder builder = new RequestSpecBuilder();
		builder.setBaseUri("http://localhost:3030");
		builder.addParam("/products");
		builder.setContentType(ContentType.JSON);
	    builder.setBody(Utils1.getPayloadWithJavaObject());
		requestspec = builder.build();
		Request = RestAssured.given().spec(requestspec);
		
		requestSpec = new RequestSpecBuilder().setBaseUri("http://localhost:3030").addParam("/products").build();
		requestSpecwithParams = new RequestSpecBuilder().setBaseUri("http://localhost:3030/stores").build();
	    requestSpecWithPayload =  new RequestSpecBuilder().setBaseUri("http://localhost:3030/products").setContentType(ContentType.JSON).setBody(Utils1.getPayloadWithJavaObject()).build();
   
	}
	
	public static ResponseOptions<Response> PostWithBody(String url) {
		
		response  = Request.post(url);
		return response;
		
	} 
	
     public static ResponseOptions<Response> GetWithQueryParameters(HashMap<String,String> queryParam){
		
		response = RestAssured.given().spec(requestSpecwithParams).queryParams(queryParam).when().get().then().extract().response();
		return response;
		
	} 
	
	 public static ResponseOptions<Response> postCall(){
		  
		//response = requestSpecWithPayload.when().post().then().extract().response(); 
		response = RestAssured.given().spec(requestSpecWithPayload).when().post().then().extract().response();
		return response;
			
	} 
	
	
}
