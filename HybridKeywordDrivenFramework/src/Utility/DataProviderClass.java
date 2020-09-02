package Utility;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderClass 
{
	@DataProvider(name = "data-provider-Test-Platform-SignUp")
	public Object[][] dpMethod(String filePath, String fileName, String sheetName) throws IOException
	{
		ExcelUtil excel = new ExcelUtil();
		excel.setExcelFile(Propertie.testExcel_filePath, Propertie.testExcel_FileName, Propertie.testExcel_TestCase_sheetName);
		return excel.readExcelTestData(Propertie.testExcel_filePath, Propertie.testExcel_FileName, Propertie.testExcel_TestCase_sheetName);
	}

}
