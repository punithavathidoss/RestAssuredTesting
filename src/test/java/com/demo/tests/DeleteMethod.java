package com.demo.tests;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteMethod {
	
	@Test
	public void testDelete() {
		
		RestAssured.baseURI = "https://reqres.in/api";

		RestAssured.
		when().
		 put("/users/2").
		then().statusCode(200).
		log().all();
	}
	
	
	@Test
	public static void delMethod() {

		int id = 2;

		RestAssured.baseURI = "https://reqres.in/api/users/2";
		RequestSpecification request = RestAssured.given();

		request.header("Content-Type", "application/json");

		Response resp = request.delete("/delete/" + id);

		System.out.println("Deleted" + resp.asString());
		System.out.println("Response status" + " " + resp.getStatusCode());

	}


}
