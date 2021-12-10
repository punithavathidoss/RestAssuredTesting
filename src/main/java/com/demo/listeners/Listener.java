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
		ReportManager.createTest(result.getMethod().getMethodName(), "Regression", "Punithavathi");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ReportManager.test.pass(result.getMethod().getMethodName() + " is Passed" );
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ReportManager.test.fail(result.getMethod().getMethodName() + " is Failed" );
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ReportManager.test.skip(result.getMethod().getMethodName() + " is skipped" );
	}

}
