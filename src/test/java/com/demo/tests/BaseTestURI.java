package com.demo.tests;

import org.testng.annotations.BeforeTest;
import static io.restassured.RestAssured.*;

public class BaseTestURI {

	@BeforeTest
	public void setUpBaseURI() {
		baseURI = "https://reqres.in/api";
	}
}
