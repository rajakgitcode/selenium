package Utility;

/*
 * This Class will have properties required for running the test
 */
public class Propertie {
	// Enter Application URL
	public static final String applicationURL = "https://cai.tools.sap/";
	// Enter Chrome Driver Path
	public static final String chromeDriverPath = "/Users/rajak/Selenium/Driver/chromedriver";
	// Enter Firefox Driver Path
	public static final String geckoDriverPath = "/Users/rajak/Selenium/Driver/geckodriver";
	// Enter Remote WebDriver URL
	public static final String remoteWebDriverURL = "http://localhost:4444/wd/hub/";
	
	// Enter Test Data Excel FileName
	public static final String testExcel_FileName = "KeywordDrivenTest.xlsx";
	// Enter Test Data FilePath
	public static final String testExcel_filePath = "/Users/rajak/git/selenium/HybridKeywordDrivenFramework/src/Resource/";
	// Enter Test Step Sheet Name
	public static final String testExcel_TestCase_sheetName = "TestStepsModel2";
	// Enter Test Case Sheet Name
	public static final String testExcel_TestSuite_SheetName = "TestCases";
	
	//Test Excel Test Case Sheet Column Number
	public static final int Col_TestCaseID = 0; //common for both sheet for mapping
	public static final int Col_TestCaseDescription = 1;
	public static final int Col_Execution = 2;
	public static final int Col_TestCaseSheetName = 3;
	//Test Excel Test Step Sheet Column Number
	public static final int Col_TestStepID = 1;
	public static final int Col_TestStepDescription = 2;
	public static final int Col_ActionKeyword = 3;
	public static final int Col_LocatorType = 4;
	public static final int Col_LocatorValue = 5;
	public static final int Col_TestData = 6;
	public static final int Col_Result = 7;
	
	// Enter selenium wait TimeOutvalue
	public static final int timeOutValue = 20;
	// Enter Maximum Retry on Test Failure
	public static final int maxRetryCount = 0;
	// Enter Test Excel ActionKeywords Column Number 
	public static final int actionKeyword_ColNo = 3;
	

}
