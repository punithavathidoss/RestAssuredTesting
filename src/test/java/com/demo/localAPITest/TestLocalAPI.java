package com.demo.localAPITest;

import static com.demo.resources.Payload.createUserLocal;
import static com.demo.resources.Payload.updateUserLocal;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demo.report.ReportManager;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TestLocalAPI extends BaseLocalTest {

	@Test(description = "Get User List")
	public void getUserList() {

		ReportManager.createLocalTest("GET User List", "Regression");

		Response re = given().contentType(ContentType.JSON).accept(ContentType.JSON)
				.when().get("/users")
				.then().extract().response();

//		ReportManager.logResponse(re.asPrettyString());
		addResponseToReport(re.asPrettyString());
		
		Assert.assertEquals(re.statusCode(), 200);
	}

	@Test(description = "Create User Test")
	public static void postMethod() {

		String firstName = "Puni";
		String lastName = "poo";
		int SubjectId = 7;

		ReportManager.createLocalTest("Post User List", "Regression");
		Response res = given()
				.when().contentType(ContentType.JSON).body(createUserLocal(firstName, lastName, SubjectId)).post("/users")
				.then().extract().response();

//		ReportManager.logResponse(res.asPrettyString());
		addResponseToReport(res.asPrettyString());
		
		Assert.assertEquals(res.statusCode(), 201);
	}


	@Test(description = "Update User Test")
	public static void updateMethod() {

		String firstName = "Puni";
		String lastName = "pooh";
		int SubjectId = 7;

		ReportManager.createLocalTest("Update User List", "Regression");
		Response resp = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(updateUserLocal(firstName, lastName, SubjectId))
				.when().put("/users/4")
				.then().extract().response();

//		ReportManager.logResponse(resp.asPrettyString());
		addResponseToReport(resp.asPrettyString());
		
		Assert.assertEquals(resp.statusCode(), 200);
	}

	@Test(description = "Patch User Test")
	public static void patchMethod() {

		String firstName = "Puni";
		String lastName = "Boo";
		int SubjectId = 9;

		ReportManager.createLocalTest("Patch User List", "Regression");
		Response respo = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(updateUserLocal(firstName, lastName, SubjectId))
				.when().put("/users/4")
				.then().extract().response();

//		ReportManager.logResponse(respo.asPrettyString());
		addResponseToReport(respo.asPrettyString());
		
		Assert.assertEquals(respo.statusCode(), 200);
	}

	@Test(description = "Delete User By Id")
	public static void deleteMethod() {
		Response respon = when().delete("/users/2").then().extract().response();

		Assert.assertEquals(respon.statusCode(), 200);
	}
}
