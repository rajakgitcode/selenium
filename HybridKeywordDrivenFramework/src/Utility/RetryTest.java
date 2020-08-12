package Utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryTest implements IRetryAnalyzer
{

	private static int retryCount = 0;
	private static int maxRetryCount = Propertie.maxRetryCount;
	
	@Override
	public boolean retry(ITestResult result) 
	{
		while(retryCount < maxRetryCount)
		{
			retryCount++;
			System.out.println("******Retrying test - " + result.getName() + " - Retry Attempt - " + retryCount);
			return true;
		}
				
		return false;
	}
	

}
