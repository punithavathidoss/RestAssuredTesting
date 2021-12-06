package com.demo.tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateMethod {

	@Test
	public static void list() {

		Response list = RestAssured.get("https://reqres.in/api/users/2");
		System.out.println(list.asString());
	}

	@Test
	public static void updateList() {

		int id = 2;

		RestAssured.baseURI = "https://reqres.in/api/users";
		RequestSpecification req = RestAssured.given();

		JSONObject params = new JSONObject();
		params.put("first_name", "Punrus");

		req.header("Content-Type", "application/json");
		req.body(params.toJSONString());

		Response re = req.put("/2" + id);

		System.out.println(re.getStatusCode());
		System.out.println("Update status:" + re.asString());
	}

	@Test
	public void testPut() {
		
		RestAssured.baseURI = "https://reqres.in/api";
		JSONObject request = new JSONObject();
		request.put("first_name", "Polo");
		request.put("last_name","Weaver");
		
		System.out.println(request.toJSONString());
		RestAssured.given().
		 header("Content-Type","application/json").
		 contentType(ContentType.JSON).
		 accept(ContentType.JSON).
		 body(request.toJSONString()).
		when().
		 put("/users/2").
		then().statusCode(200).
		log().all();
	}
}
