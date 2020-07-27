package Utility;

/*
 * This Class will have properties required for running the test
 */
public class Propertie 
{
	//Enter Application URL
	public static final String applicationURL = "https://cai.tools.sap/";
	//Enter Chrome Driver Path
	public static final String chromeDriverPath = "/Users/rajak/Documents/Selenium/chromedriver";
	//Enter Firefox Driver Path
	public static final String geckoDriverPath = "/Users/rajak/Documents/Selenium/geckodriver";
	//Enter Remote WebDriver URL
	public static final String remoteWebDriverURL = "http://localhost:4444/wd/hub/";
	//Enter Test Data Excel FileName 
	public static final String testData_FileName = "TestData.xlsx";
	//Enter Test Data FilePath
	public static final String testData_filePath = "/Users/rajak/git/repository/SAPPlatformTest/src/resources/";
	//Enter Test Data Sheet Name
	public static final String testData_sheetName = "Sheet1";
	//Enter selenium wait TimeOutvalue
	public static final int timeOutValue = 30;
	//Enter Maximum Retry on Test Failure
	public static final int maxRetryCount = 0;
	
}
