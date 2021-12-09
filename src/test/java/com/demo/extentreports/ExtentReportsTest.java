package com.demo.extentreports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsTest {

	@Test
	public void extentTest() throws IOException {

		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("index.html");
		
//		ExtentSparkReporter spark = new ExtentSparkReporter("testNG.xml");
		
		final File CONF = new File("extentconfig.xml");
		spark.loadXMLConfig(CONF);
		
		final File CONF1 = new File("extentConfig.json");
		spark.loadJSONConfig(CONF1);
		
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Automation Report");
		spark.config().setReportName("Rest Assured API Test");
		extent.attachReporter(spark);

		ExtentTest test = extent.createTest("Reqres API").assignAuthor("Milburn").assignCategory("Smoke").assignDevice("chrome 96");
		test.pass("Test Started successfully");
		test.info("URL is loaded");
		test.info("Values entered");
		test.pass("Automation Test completed successfully");

		ExtentTest tst = extent.createTest("Soap XML").assignCategory("Regression").assignAuthor("Otis").assignAuthor("Gibson").assignDevice("Firefox 61");
		tst.pass("Automation Test Started successfully");
		tst.info("URL is loaded");
		tst.info("Values entered");
		tst.fail("Automation Test not completed successfully");

		extent.flush();
		Desktop.getDesktop().browse(new File("index.html").toURI());
		
//		 test.skip("");
	}
}
