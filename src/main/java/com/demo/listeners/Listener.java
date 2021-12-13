package com.demo.listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.demo.report.ReportManager;

public class Listener implements ITestListener, ISuiteListener {

	@Override
	public void onStart(ISuite suite) {
		ReportManager.setUpReport();
	}

	@Override
	public void onFinish(ISuite suite) {
		ReportManager.reportFlush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		ReportManager.createTest(result.getMethod().getDescription(), "Regression", "Punithavathi");
		ReportManager.test.pass(result.getMethod().getDescription() + " is Started" );
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ReportManager.test.pass(result.getMethod().getDescription() + " is Passed" );
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ReportManager.test.fail(result.getMethod().getDescription() + " is Failed" );
		ReportManager.test.fail(result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ReportManager.test.skip(result.getMethod().getDescription() + " is skipped" );
	}

}
