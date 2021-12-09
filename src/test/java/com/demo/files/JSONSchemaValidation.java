package com.demo.files;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JSONSchemaValidation {
	@BeforeTest
	public void setUp() {
		baseURI = "http://reqres.in/api";
	}

	@Test
	public void getUsers() {
		
	    given().
		 get("/users?page=2").
		then().
		 assertThat().body(matchesJsonSchemaInClasspath("schema.json")).statusCode(200).log().all();
	}
	
//	@Test
//	public void getUserById() {
//	    given().
//		 get("/users/2").
//		then().
//		 assertThat().body(matchesJsonSchemaInClasspath("schema.json")).statusCode(200);
//	}

	
}
