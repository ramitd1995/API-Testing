package API_Testing_TestNG_BDD.API_TestNG_BDD;

import static com.jayway.restassured.RestAssured.given;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import static org.hamcrest.Matchers.lessThan;

//Reference github: https://github.com/typicode/json-server

public class API_Testing_1 {
	
	@Test(description = "Get API method", enabled = false)
	public void getAPI(){
		
		 Response response = given()
							.param("isGlobal",true)
							.param("name", "Wells Fargo")
							.when()
							.get("http://localhost:3000/Banking");
		 
		Assert.assertEquals(response.getStatusCode(), 200,"GET API failed to respond");
		System.out.println(response.asString());						 		 			
	}
	
	
	@Test(description = "POST API method", enabled = false)
	public void postAPI(){
		
		 Response response = given().
					 		body(" { \"id\": 2, \"name\": \"Tesla\", \"ceo\": \"Elon Musk\", \"isGlobal\": true }").
					 		when().
					 		contentType(ContentType.JSON).
					 		post("http://localhost:3000/Automobile");
		 				
		                Assert.assertEquals(response.getStatusCode(), 201,"POST API failed to respond");
		 				System.out.println(response.asString());
	}	
	
	
	@Test(description = "PUT API method", enabled = false)
	public void putAPI(){
		
		
		 Response response = given().
					 		body("{\"id\":2,\"name\":\"Ebay\",\"ceo\":\"Jamie Iannone\"}").
					 		when().
					 		contentType(ContentType.JSON).
					 		put("http://localhost:3000/E-Commerce/2");
		 				
		 				Assert.assertEquals(response.getStatusCode(), 200,"PUT API failed to respond");
		 				System.out.println(response.asString());	 
	}
	
	@Test(description = "PATCH API method", enabled = false)
	public void patchAPI(){
		
		
		 Response response = given().
				 		body("{\"name\": \"Fabric\"}").
				 		when().
				 		contentType(ContentType.JSON).
				 		patch("http://localhost:3000/E-Commerce/1");
		 
		 			Assert.assertEquals(response.getStatusCode(), 200,"PATCH API failed to respond");	
		 			System.out.println(response.asString());	
	}	
	
	
	@Test(description = "Delete API method", enabled = false)
	public void deleteAPI(){
		
		 Response response = given().
					 		 when().
					 		 delete("http://localhost:3000/Banking/1");
		 
		 			Assert.assertEquals(response.getStatusCode(), 200,"DELETE API failed to respond");	
		 			System.out.println(response.asString());		
	}	
	
	@Test(description = "API Response Time", enabled = true)
	public void responseTime(){
		
		 Response response = given().
					 		 when().
					 		 get("http://localhost:3000/E-Commerce");
		 
		 Long responseTime = response.
						 	 then().
						 	 extract().
						 	 time();
				 		
		 			 System.out.println(response.asString());
		 			 System.out.println("Response Time = " + responseTime);
		 			 		
	}	
  }
