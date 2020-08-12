package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelUtil 
{
	private static Workbook workbook;
	private static Sheet sheet;
	private static Cell cell;
	private static Row row;
	private static DataFormatter formatter;
	
	public static void setExcelFile(String filePath, String fileName, String sheetName) throws IOException
	{
		FileInputStream fis = new FileInputStream(filePath+fileName);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
	}
	
	public static String getCellData(int rowNum, int colNum)
	{
		String cellData;
		cell = sheet.getRow(rowNum).getCell(colNum);
		cellData = cell.getStringCellValue();
		return cellData;
	}
	
	public static int getRowCount()
	{
		return sheet.getPhysicalNumberOfRows();
	}
	
	public static int getColumnCount()
	{
		return sheet.getRow(0).getPhysicalNumberOfCells();
	}
	
	// Read Excel file and return data as object
	public Object[][] readExcelTestData(String filePath, String fileName, String sheetName) {
			Object[][] excelTestData = null;

			try {
				File file = new File(filePath + "/" + fileName);
				FileInputStream fileInputStream = new FileInputStream(file);

				String fileExtention = fileName.substring(fileName.indexOf("."));

				if (fileExtention.equalsIgnoreCase(".xlsx")) {
					workbook = new XSSFWorkbook(fileInputStream);
				} else if (fileExtention.equalsIgnoreCase(".xls")) {
					workbook = new HSSFWorkbook(fileInputStream);
				}

				Sheet sheet = workbook.getSheet(sheetName);

				if (sheet == null) {
					throw new IllegalArgumentException("No sheet exists with name " + sheetName);
				}

				int rowCount = sheet.getPhysicalNumberOfRows();
				int rowCount1 = sheet.getLastRowNum() - sheet.getFirstRowNum();
				int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

				System.out.println(rowCount + "-" + rowCount1 + "-" + colCount);

				excelTestData = new Object[rowCount - 1][colCount];

				for (int i = 1; i < rowCount; i++) {
					row = sheet.getRow(i);

					for (int j = 0; j < colCount; j++) {
						if (row == null) {
							excelTestData[i][j] = "";
						} else {
							cell = row.getCell(j);

							if (cell == null) {
								excelTestData[i][j] = "";
							} else {
								String cellString = formatter.formatCellValue(cell);
								excelTestData[i - 1][j] = cellString;
							}

						}
					}

				}

				workbook.close();
				fileInputStream.close();

				// printing the excel test data object array
				for (int i = 0; i < excelTestData.length; i++) {
					for (int j = 0; j < excelTestData[i].length; j++) {
						System.out.print(excelTestData[i][j] + "\t");
					}
					System.out.println("");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			return excelTestData; // returns excel data
		}
}
