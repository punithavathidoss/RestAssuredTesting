package com.demo.APItests;

import static com.demo.utils.JsonFormatter.jsonPathResponse;
import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetMethod extends BaseTestURI {

	@Test(description = "Get User By Id")
	public static void getUsersById() {

		Response resp = given().when().get("/users/2").then().extract().response();
		
//		ReportManager.logResponse(resp.asPrettyString());
		addResponseToReport(resp.asPrettyString());
		JsonPath jpath = jsonPathResponse(resp);

		Assert.assertEquals(jpath.getInt("data.id"), 2);
		Assert.assertEquals(jpath.getString("data.first_name"), "Janet");
		Assert.assertNotEquals(jpath.getString("data.last_name"), "Hello");
		Assert.assertEquals(jpath.getString("data.email"), "janet.weaver@reqres.in");
	}

	@Test(description = "Get Users list")
	public static void getUsers() {

		Response res = given().queryParam("page", "2").log().all().when().get("/users").then().extract().response();

//		ReportManager.logResponse(res.asPrettyString());
		addResponseToReport(res.asPrettyString());
		
		JsonPath jsPath = jsonPathResponse(res);

		Assert.assertEquals(jsPath.getInt("page"), 2);
		Assert.assertEquals(jsPath.getInt("per_page"), 6);
		Assert.assertNotEquals(jsPath.getInt("data[0].id"), 10);
		Assert.assertEquals(jsPath.getString("data[3].email"), "byron.fields@reqres.in");
		Assert.assertEquals(jsPath.getString("data[3].first_name"), "Byron");
		Assert.assertNotEquals(jsPath.getString("data[3].last_name"), "Edwards");

	}

}
