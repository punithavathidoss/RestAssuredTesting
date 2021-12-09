package com.demo.APItests;

import static io.restassured.RestAssured.baseURI;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseTestURI {

	static ExtentTest test;
	static ExtentReports extent;

	@BeforeTest
	public static void setUpBaseURI() {
		baseURI = "https://reqres.in/api";
	}

	@BeforeSuite
	public static void setUpReport() {
		
		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("report/index.html");
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Automation Report");
		spark.config().setReportName("Rest Assured API Test");
		extent.attachReporter(spark);
	}

	@AfterSuite
	public static void reportFlush() {
		extent.flush();
	}

	public static void createTest(String testName, String testType, String authName) {
		test = extent.createTest(testName)
				.assignCategory(testType)
				.assignAuthor(authName)
				.assignDevice("chrome 96");
	}
}
