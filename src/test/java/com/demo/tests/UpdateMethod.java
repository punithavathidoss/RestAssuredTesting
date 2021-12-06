package com.demo.tests;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class UpdateMethod {

	@BeforeTest
	public void setUp() {
		baseURI = "https://reqres.in/api/users";
	}

	@Test(priority = 1)
	public static void updateList() {

		JSONObject request = new JSONObject();
		request.put("first_name", "Polo");
		request.put("last_name", "Weaver");

		System.out.println(request.toJSONString());

		given().
		 header("Content-Type", "application/json").
		 contentType(ContentType.JSON).
		 accept(ContentType.JSON)
		.body(request.toJSONString()).
	    when().
	     put("/users/2").
	    then().
	     statusCode(200).
	      log().all();

	}

	@Test(priority = 2)
	public void patchTest() {

		int id = 2;

		JSONObject params = new JSONObject();
		params.put("first_name", "Punrus");

		System.out.println(params.toJSONString());

		given().
		 header("Content-Type", "application/json").
		 contentType(ContentType.JSON).
		 accept(ContentType.JSON).
		 body(params.toJSONString()).
		when().
		 patch("/users/2").
		then().
		 statusCode(200).
		 log().all();
	}
}
