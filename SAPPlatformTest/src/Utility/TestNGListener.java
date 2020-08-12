package Utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListener implements ITestListener {
	public void onStart(ITestContext context) {
		System.out.println("onStart method started ");
	}

	public void onFinish(ITestContext context) {
		System.out.println("onFinish method started ");
	}

	public void onTestStart(ITestResult result) {
		System.out.println("Test Started for " + result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("TestSuccess for Method " + result.getName());
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("TestFailure for Method " + result.getName());
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("TestSkipped for Method" + result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("onTestFailedButWithinSuccessPercentage" + result.getName());
	}
}
