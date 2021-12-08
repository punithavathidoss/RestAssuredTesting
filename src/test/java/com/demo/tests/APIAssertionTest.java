package com.demo.tests;

import static io.restassured.RestAssured.*;
import static com.demo.resources.Payload.*;
import static com.demo.utils.JsonFormatter.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class APIAssertionTest extends BaseTestURI {


	@Test
	public static void getUsersById() {

		Response resp = given().when().get("/users/2").then().extract().response();

		JsonPath jPath = jsonPathResponse(resp);

		Assert.assertEquals(jPath.getInt("data.id"), 2);
		Assert.assertEquals(jPath.getString("data.first_name"), "Janet");
		Assert.assertNotEquals(jPath.getString("data.last_name"), "Hello");
		Assert.assertEquals(jPath.getString("data.email"), "janet.weaver@reqres.in");
	}

	@Test
	public static void getUsers() {
		Response res = given().queryParam("page", "2").log().all().when().get("/users").then().extract().response();

		JsonPath jsPath = jsonPathResponse(res);

		Assert.assertEquals(jsPath.getInt("page"), 2);
		Assert.assertEquals(jsPath.getInt("per_page"), 6);
		Assert.assertNotEquals(jsPath.getInt("data[0].id"), 10);
		Assert.assertEquals(jsPath.getString("data[3].email"), "byron.fields@reqres.in");
		Assert.assertEquals(jsPath.getString("data[3].first_name"), "Byron");
		Assert.assertNotEquals(jsPath.getString("data[3].last_name"), "Edwards");

	}

	@Test
	public static void createUserandValidate() {

		String name ="Puni";
		String job = "Analyst";

		Response re = given()
				      .when().contentType(ContentType.JSON).body(createUser(name,job))
				      .post("/users")
				      .then().extract().response();

		JsonPath jsoPath = jsonPathResponse(re);

		Assert.assertEquals(re.statusCode(), 201);
		Assert.assertNotNull(jsoPath.getInt("id"));
		Assert.assertEquals(jsoPath.getString("name"), "Puni");
		Assert.assertEquals(jsoPath.getString("job"), "Analyst");
		Assert.assertNotNull(jsoPath.getString("createdAt"));
	}

	@Test
	public static void updateAndValidate() {

		String name = "Puni";
		String job = "zion resident";
		String role = "Testing";
		
		Response rsp = given().body(updateUser(name, job, role)).
	               	   when().contentType(ContentType.JSON).put("/users/2").
		               then().extract().response();
		
		
		//Alternate
//		Response rsp = given().body(updateUser("Puni", "zion resident", "Testing")).
//            	   when().contentType(ContentType.JSON).put("/users/2").
//	               then().extract().response();

		
		JsonPath jsonPath = jsonPathResponse(rsp);

		Assert.assertEquals(rsp.statusCode(), 200);
		Assert.assertEquals(jsonPath.getString("name"), name);
		Assert.assertEquals(jsonPath.getString("job"), job);
		Assert.assertEquals(jsonPath.getString("role"), role);
		Assert.assertNotNull(jsonPath.getString("updatedAt"));

	}
	
	@Test
	public void deleteMethodValidation() {
		Response responce =  when().delete("/users/2").
		                     then().extract().response();
		
		Assert.assertEquals(responce.statusCode(), 204);
	}

}
