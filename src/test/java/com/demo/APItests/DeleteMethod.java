package com.demo.APItests;

import static io.restassured.RestAssured.when;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class DeleteMethod {

	@Test
	public void deleteMethodValidation() {
		
		BaseTestURI.createTest("Delete User Test", "Regression", "Punithavathi");
		
		Response responce = when().delete("/users/2").then().extract().response();

		Assert.assertEquals(responce.statusCode(), 204);
	}

}
