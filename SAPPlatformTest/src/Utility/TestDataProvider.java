package Utility;

import org.testng.annotations.DataProvider;

/*
 * This DataProvider class having TestNG dataProvider method to provide data to Test
 */
public class TestDataProvider {
	// Data Provider method Reading excel and providing data to Test
	@DataProvider(name = "data-provider-Test-Platform-SignUp")
	public static Object[][] dpMethod_PlatformSignUpData() {
		// non-static reference
		ExcelUtil excel = new ExcelUtil();
		excel.setExcelFile(Propertie.testData_filePath, Propertie.testData_FileName, Propertie.testData_sheetName);
		return excel.readExcelTestData(Propertie.testData_filePath, Propertie.testData_FileName,
				Propertie.testData_sheetName);

		// Static Reference
		// return ExcelUtil.readExcelTestData(Propertie.testData_filePath,
		// Propertie.testData_FileName, Propertie.testData_sheetName);

	}

}
