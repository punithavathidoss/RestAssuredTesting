package com.demo.tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class APIAssertionTest {

	@BeforeTest
	public void setUpBaseURI() {
		baseURI = "https://reqres.in/api";
	}

	@Test
	public static void getUsersById() {

		Response resp = given().when().get("/users/2").then().extract().response();

		JsonPath jPath = new JsonPath(resp.asString());

		Assert.assertEquals(jPath.getInt("data.id"), 2);
		Assert.assertEquals(jPath.getString("data.first_name"), "Janet");
		Assert.assertNotEquals(jPath.getString("data.last_name"), "Hello");
		Assert.assertEquals(jPath.getString("data.email"), "janet.weaver@reqres.in");
	}

	@Test
	public static void getUsers() {
		Response res = given().queryParam("page", "2").log().all().when().get("/users").then().extract().response();

		JsonPath jsPath = new JsonPath(res.asString());

		Assert.assertEquals(jsPath.getInt("page"), 2);
		Assert.assertEquals(jsPath.getInt("per_page"), 6);
		Assert.assertNotEquals(jsPath.getInt("data[0].id"), 10);
		Assert.assertEquals(jsPath.getString("data[3].email"), "byron.fields@reqres.in");
		Assert.assertEquals(jsPath.getString("data[3].first_name"), "Byron");
		Assert.assertNotEquals(jsPath.getString("data[3].last_name"), "Edwards");

	}

	@Test
	public static void createUserandValidate() {

		JSONObject postRequest = new JSONObject();
		postRequest.put("name", "Puni");
		postRequest.put("job", "Analyst");

		Response re = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(postRequest.toJSONString())
				      .when().post("/users")
				      .then().extract().response();

		JsonPath jsoPath = new JsonPath(re.asString());

		Assert.assertEquals(re.statusCode(), 201);
		Assert.assertNotNull(jsoPath.getInt("id"));
		Assert.assertEquals(jsoPath.getString("name"), "Puni");
		Assert.assertEquals(jsoPath.getString("job"), "Analyst");
		Assert.assertNotNull(jsoPath.getString("createdAt"));
	}

	@Test
	public static void updateAndValidate() {

		JSONObject putRequest = new JSONObject();

		putRequest.put("name", "Puni");
		putRequest.put("job", "zion resident");

		Response rsp = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(putRequest.toJSONString()).
	               	   when().put("/users/2").
		               then().extract().response();

		JsonPath jsonPath = new JsonPath(rsp.asString());

		Assert.assertEquals(rsp.statusCode(), 200);
		Assert.assertEquals(jsonPath.getString("name"), "Puni");
		Assert.assertEquals(jsonPath.getString("job"), "zion resident");
		Assert.assertNotNull(jsonPath.getString("updatedAt"));

	}
	
	@Test
	public void deleteMethod() {
		Response responce =  when().delete("/users/2").
		                     then().extract().response();
		
		Assert.assertEquals(responce.statusCode(), 204);
	}

}
