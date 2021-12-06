package com.demo.tests;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostMethod {

	@BeforeTest
	public void setUp() {
		RestAssured.baseURI = "https://reqres.in/api";
	}
	
	@Test
	public static void postData() {

//		RestAssured.baseURI = "https://reqres.in/api/users";

		JSONObject postData = new JSONObject();
		postData.put("name", "Puni");
		postData.put("Job", "Analyst");

		// request.header("Content-Type", "application/json");

		RequestSpecification request = RestAssured.given();
		request.body(postData.toJSONString());
		Response re = request.post();
		System.out.println("Response body: " + re.body().asString());
	}

	@Test
	public void sample() {

//		RestAssured.baseURI = "https://reqres.in/api/users";
		Map<String, Object> post = new HashMap<String, Object>();

//		post.put("name", "Polo");
//		post.put("job", "Analyst");
//		System.out.println(post);

		JSONObject request = new JSONObject(post);
		request.put("name", "Polo");
		request.put("job", "Testing Engineer");

		System.out.println(request.toJSONString());

	}

}
