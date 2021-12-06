package com.demo.tests;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostMethod {

	@BeforeTest
	public void setUp() {
		baseURI = "https://reqres.in/api";
	}

	@Test
	public void samplePost() {

		Map<String, Object> post = new HashMap<String, Object>();
		JSONObject request = new JSONObject(post);
		
		request.put("name", "Polo");
		request.put("job", "Testing Engineer");

		System.out.println(request.toJSONString());

		given().
		 body(request.toJSONString()).
		when().
		 post("/users").
		then().
		 statusCode(201).
		log().all();
	}

	@Test
	public static void postData() {
		
		Map<String, Object> post = new HashMap<String, Object>();
		JSONObject postData = new JSONObject();
		
		postData.put("name", "Puni");
		postData.put("Job", "Analyst");
		System.out.println(postData.toJSONString());

		given().
		 body(postData.toJSONString()).
		when().
		 post("/users").
		then().
		 statusCode(201).
		log().all();
	}

}
