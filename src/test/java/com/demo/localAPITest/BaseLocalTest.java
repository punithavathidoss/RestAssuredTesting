package com.demo.localAPITest;

import static io.restassured.RestAssured.baseURI;

import org.testng.annotations.BeforeTest;

import com.demo.report.ReportManager;

public class BaseLocalTest {

	@BeforeTest
	public void setUp() {
		baseURI = "http://localhost:3000";
	}

	public static void addResponseToReport(String response) {
		ReportManager.logResponse(response);
	}
}
