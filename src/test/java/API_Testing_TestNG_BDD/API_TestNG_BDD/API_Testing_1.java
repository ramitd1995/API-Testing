package API_Testing_TestNG_BDD.API_TestNG_BDD;

import static com.jayway.restassured.RestAssured.given;
import java.util.ArrayList;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import static org.hamcrest.Matchers.lessThan;

//Reference github: https://github.com/typicode/json-server

public class API_Testing_1 {
	
	@Test(description = "Sample Test for Get API", enabled = false)
	public void getAPI(){
		
		
		 Response resp = given().auth()
				        .basic("ramitdlambdatest", "Ar7sr82ACbQXRi23ujktWaSuBRq9jOjInvBaelieyC00XavZUP")
						.param("build_id","155913")
						.when()
						.get("https://api.lambdatest.com/automation/api/v1/builds");
		 
		int statusCode = resp.getStatusCode();
		System.out.println(statusCode);
		 
		Assert.assertEquals(statusCode, 200,"GET API did not respond");
						 
		 
		 ArrayList<String> json= resp.
		 						then().
		 						contentType(ContentType.JSON).
		 						extract().
		 						path("data");  // json expression paths
		
		//System.out.println(resp.asString());	
		System.out.println(json);	
		
		
	}
	
	
	
	@Test(description = "Sample Test for POST API", enabled = false)
	public void postAPI(){
		
		 Response resp = given().
				 		body(" { \"id\": 2, \"title\": \"sent-from-post-api\", \"author\": \"ramit-dhamija\" }").
				 		when().
				 		contentType(ContentType.JSON).
				 		post("http://localhost:3000/posts");
		 
		 				System.out.println(resp.asString());	// Updates the db.json file with new info in post object
	}	
	
	
	
	@Test(description = "Sample Test for POST API using PostClass object", enabled = false)
	public void postClassAPI(){
		
		PostClass postJson = new PostClass();
		postJson.setID("4");
		postJson.setTitle("using-Post-Class");
		postJson.setAuthor("Youtube");
		
		 Response resp = given().
				 		body(postJson).
				 		when().
				 		contentType(ContentType.JSON).
				 		post("http://localhost:3000/posts");
		 
		 				System.out.println(resp.asString());	// Updates the db.json file with new info in post object
	}	
	
	
	@Test(description = "Sample Test for PUT API", enabled = false)
	public void putAPI(){
		
		
		 Response resp = given().
				 		body("{\r\n" + 
				 				"  \"name\": \"morpheus\",\r\n" + 
				 				"  \"job\": \"zion resident\"\r\n" + 
				 				"} ").
				 		when().
				 		contentType(ContentType.JSON).
				 		put("https://reqres.in/api/users/2");
		 
		 				System.out.println(resp.asString());	// Updates the db.json file with updated info 
	}
	
	@Test(description = "Sample Test for PATCH API", enabled = false)
	public void patchAPI(){
		
		
		 Response resp = given().
				 		auth()
				 		.basic("ramitdlambdatest", "Ar7sr82ACbQXRi23ujktWaSuBRq9jOjInvBaelieyC00XavZUP").
				 		body("{\r\n" + 
				 				"  \"name\": \"mytest\",\r\n" + 
				 				"  \"status_ind\": \"passed\"\r\n" + 
				 				"} ").
				 		when().
				 		contentType(ContentType.JSON).
				 		patch("https://api.lambdatest.com/automation/api/v1/sessions/3174bc61-963a-4ae4-894b-c3cec7c50938");
		 
		 				System.out.println(resp.asString());	
	}	
	
	@Test(description = "Sample Test for Delete API", enabled = false)
	public void deleteAPI(){
		
		 Response resp = given().
				 		auth().	
				 		basic("ramitdlambdatest", "Ar7sr82ACbQXRi23ujktWaSuBRq9jOjInvBaelieyC00XavZUP").
				 		when().
				 		delete("https://api.lambdatest.com/automation/api/v1/builds/155913");
		 
		 				System.out.println(resp.asString());	
	}	
	
	@Test(description = "API Response Time", enabled = true)
	public void responseTime(){
		
		 Response resp = given().
				 		when().
				 		get("http://localhost:3000/posts");
		 
		 Long time = resp.
				 	 then().
				 	 extract().
				 	 time();
				 		
		 			 System.out.println(resp.asString());
		 			 System.out.println("================================================================================================");
		 			 System.out.println("Response Time = " + time);
		 			 
		 			// API response Time assertion
		 			 
		 			 given().
		 			 when().
		 			 get().
		 			 then().
		 			 and().
		 			 time(lessThan(800L));
	}	
  }
