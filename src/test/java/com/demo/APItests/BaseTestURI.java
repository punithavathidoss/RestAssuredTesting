package com.demo.APItests;

import static io.restassured.RestAssured.baseURI;

import org.testng.annotations.BeforeTest;

public class BaseTestURI {

	@BeforeTest
	public static void setUpBaseURI() {
		baseURI = "https://reqres.in/api";
	}

}
