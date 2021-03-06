package com.demo.APItests;

import static io.restassured.RestAssured.baseURI;

import org.testng.annotations.BeforeTest;

import com.demo.report.ReportManager;

public class BaseTestURI {

	@BeforeTest
	public static void setUpBaseURI() {
		baseURI = "https://reqres.in/api";
	}

	public static void addResponseToReport(String response) {
		ReportManager.logResponse(response);
	}
}
