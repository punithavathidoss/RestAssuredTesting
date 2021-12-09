package com.demo.localAPITest;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class TestLocalAPI {

	@BeforeTest
	public void setUp() {
		baseURI = "http://localhost:3000";
	}

	@Test
	public void get() {
		given().
		 get("/users").
		then().statusCode(200).
		 log().all();
	}

	@Test
	public void postMethod() {

		JSONObject postRequest = new JSONObject();

		postRequest.put("firstName", "Puni");
		postRequest.put("lastName", "poo");

		given().
		 contentType(ContentType.JSON).
		 accept(ContentType.JSON).
		 body(postRequest.
		 toJSONString()).
		when().
		 post("/users").
		then().
		 statusCode(201);
	}
	
	@Test
	public void updateMethod() {
		JSONObject putRequest = new JSONObject();
		
		putRequest.put("firstName", "Puni");
		putRequest.put("lastName", "poo");
		putRequest.put("SubjectId", 7);
		
		given().
		 contentType(ContentType.JSON).
		 accept(ContentType.JSON).
		 body(putRequest.toJSONString()).
		when().
		 put("/users/4").
		then().
		 statusCode(200);
	}
	
	@Test 
	public void patchMethod() {
		JSONObject putRequest = new JSONObject();
		
		putRequest.put("firstName", "Puni");
		putRequest.put("lastName", "Boo");
		
		given().
		 contentType(ContentType.JSON).
		 accept(ContentType.JSON).
		 body(putRequest.toJSONString()).
		when().
		 put("/users/4").
		then().
		 statusCode(200);
	}
	
	@Test
	public void deleteMethod() {
		when().
		delete("/users/2").
		then().
		statusCode(200);
	}
}
