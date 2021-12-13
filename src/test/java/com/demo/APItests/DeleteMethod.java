package com.demo.APItests;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class DeleteMethod {

	@Test(description = "Delete User By given Id")
	public static void deleteMethodValidation() {

		Response response = given().when().delete("/users/2").then().extract().response();
		
		Assert.assertEquals(response.statusCode(), 204);
	}

}
