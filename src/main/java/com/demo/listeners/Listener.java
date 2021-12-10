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
		System.out.println("In On Test start method");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("In On Test Success method");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("In On Test Failure method");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("In On Test Skipped method");
	}

}
