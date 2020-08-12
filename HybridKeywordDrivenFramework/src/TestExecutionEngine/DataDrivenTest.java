package TestExecutionEngine;

import org.testng.annotations.Test;

import Utility.DataProviderClass;
import Utility.RetryTest;

public class DataDrivenTest 
{
	
	@Test(dataProvider = "data-provider-Test-Platform-SignUp", dataProviderClass = DataProviderClass.class, groups = {"functional" }, retryAnalyzer = RetryTest.class, description = "Test 1 - Testing Platform sign up with Excel Reader", enabled = true)
	public void test1_Platform_Sign_Up(String firstName, String lastName, String email, String password, String retypePasswd, String opAuth, String toutAuth) throws InterruptedException 
	{
		System.out.println("*****Test Started - test_Platform_Sign_Up_With_Excel_Reader*****");
		
	}
}
