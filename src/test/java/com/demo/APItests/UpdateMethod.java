package com.demo.APItests;

import static com.demo.resources.Payload.updateUser;
import static com.demo.utils.JsonFormatter.jsonPathResponse;
import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class UpdateMethod extends BaseTestURI{


	@Test(description = "Update User with data")
	public static void updateAndValidate() {

		String name = "Puni";
		String job = "zion resident";
		String role = "Testing";

		Response rsp = given().body(updateUser(name, job, role)).
				when().contentType(ContentType.JSON).put("/users/2").
				then().extract().response();
		
//		ReportManager.logResponse(rsp.asPrettyString());
		addResponseToReport(rsp.asPrettyString());
		
		JsonPath jsonPath = jsonPathResponse(rsp);

		Assert.assertEquals(rsp.statusCode(), 200);
		Assert.assertEquals(jsonPath.getString("name"), name);
		Assert.assertEquals(jsonPath.getString("job"), job);
		Assert.assertEquals(jsonPath.getString("role"), role);
		Assert.assertNotNull(jsonPath.getString("updatedAt"));

	}

	@Test(priority = 2, description = "Patch data test")
	public void patchTest() {

		String name = "Kate";
		String job = "Cooker";
		String role = "Judge";

		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(updateUser(name,job,role))
				.when().put("/users/2")
				.then().log().all().extract().response();

//		ReportManager.logResponse(response.asPrettyString());
		addResponseToReport(response.asPrettyString());
		
		Assert.assertEquals(response.statusCode(), 200);
		JsonPath jsonPath =jsonPathResponse(response);
		Assert.assertEquals(jsonPath.getString("name"), name);
		Assert.assertEquals(jsonPath.getString("job"), job);
		Assert.assertEquals(jsonPath.getString("role"), role);
		Assert.assertNotNull(response.body());
	}
}
