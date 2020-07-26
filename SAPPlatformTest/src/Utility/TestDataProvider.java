package Utility;

import org.testng.annotations.DataProvider;

public class TestDataProvider  
{
	@DataProvider(name = "data-provider-Test-Platform-SignUp")
	public static Object[][] dpMethod_PlatformSignUpData()
	{
			//non-static reference
			ExcelUtil excel = new ExcelUtil();
			excel.setExcelFile("/Users/rajak/git/repository/SAPPlatformTest/src/resources/", "TestData.xlsx", "Sheet1");
			return excel.readExcelTestData("/Users/rajak/git/repository/SAPPlatformTest/src/resources/", "TestData.xlsx", "Sheet1");
			
			//Static Reference
			//return ExcelUtil.readExcelTestData("/Users/rajak/git/repository/SAPPlatformTest/src/resources/", "TestData.xlsx", "Sheet1");
		
	}
	
}
