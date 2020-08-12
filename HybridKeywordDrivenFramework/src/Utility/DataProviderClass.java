package Utility;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderClass 
{
	@DataProvider(name = "data-provider-Test-Platform-SignUp")
	public Object[][] dpMethod(String filePath, String fileName, String sheetName) throws IOException
	{
		ExcelUtil excel = new ExcelUtil();
		excel.setExcelFile(Propertie.testData_filePath, Propertie.testData_FileName, Propertie.testData_sheetName);
		return excel.readExcelTestData(Propertie.testData_filePath, Propertie.testData_FileName, Propertie.testData_sheetName);
	}

}
