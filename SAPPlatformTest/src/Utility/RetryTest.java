package Utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/*
 * This class has a methods to Retry the tests when it is failed on executions for max number of time specified
 */
public class RetryTest implements IRetryAnalyzer {
	private int retryCount = 0;
	private int maxRetryCount = Propertie.maxRetryCount;

	@Override
	public boolean retry(ITestResult result) {
		while (retryCount < maxRetryCount) {
			retryCount++;
			System.out.println("******Retrying test - " + result.getName() + " - Retry Attempt - " + retryCount);
			return true;
		}

		return false;
	}

}
