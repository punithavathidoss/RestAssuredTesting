package com.demo.APItests;

import static com.demo.utils.JsonFormatter.jsonPathResponse;
import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetMethod extends BaseTestURI {


	@Test
	public static void getUsersById() {

		BaseTestURI.createTest("Get User by Id Test", "Regression", "Punithavathi");
		
		Response resp = given().when().get("/users/2").then().extract().response();

		JsonPath jpath = jsonPathResponse(resp);

		Assert.assertEquals(jpath.getInt("data.id"), 2);
		Assert.assertEquals(jpath.getString("data.first_name"), "Janet");
		Assert.assertNotEquals(jpath.getString("data.last_name"), "Hello");
		Assert.assertEquals(jpath.getString("data.email"), "janet.weaver@reqres.in");
	}

	@Test
	public static void getUsers() {
		
		BaseTestURI.createTest("Get User Test", "Regression", "Milburn");
		
		Response res = given().queryParam("page", "2").log().all().when().get("/users").then().extract().response();

		JsonPath jsPath = jsonPathResponse(res);

		Assert.assertEquals(jsPath.getInt("page"), 2);
		Assert.assertEquals(jsPath.getInt("per_page"), 6);
		Assert.assertNotEquals(jsPath.getInt("data[0].id"), 10);
		Assert.assertEquals(jsPath.getString("data[3].email"), "byron.fields@reqres.in");
		Assert.assertEquals(jsPath.getString("data[3].first_name"), "Byron");
		Assert.assertNotEquals(jsPath.getString("data[3].last_name"), "Edwards");

	}

}
