package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.log4testng.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelUtil 
{
	private static Workbook workbook;
	private static Sheet sheet, ts_Sheet, tc_Sheet;
	private static Cell cell, ts_Cell, tc_Cell;
	private static Row row, ts_Row, tc_Row;
	private static DataFormatter formatter = new DataFormatter();
	static Logger log = Logger.getLogger(ExcelUtil.class);
	
	
	public static void setExcelFile(String filePath, String fileName, String sheetName) throws IOException
	{
		FileInputStream fis = new FileInputStream(filePath+fileName);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
	}
	
	public static void setExcelFile(String filePath, String fileName, String ts_SheetName, String tc_SheetName) throws IOException
	{
		FileInputStream fis = new FileInputStream(filePath+fileName);
		workbook = new XSSFWorkbook(fis);
		ts_Sheet = workbook.getSheet(ts_SheetName);
		tc_Sheet = workbook.getSheet(tc_SheetName);
	}
	
	public static String getCellData(int rowNum, int colNum)
	{
		String cellData;
		cell = sheet.getRow(rowNum).getCell(colNum);
		cellData = cell.getStringCellValue();
		return cellData;
	}
	
	public static String getCellData(int rowNum, int colNum, String sheetName)
	{
		String cellData;
		sheet = workbook.getSheet(sheetName);
		cell = sheet.getRow(rowNum).getCell(colNum);
		cellData = cell.getStringCellValue();
		return cellData;
	}
	
	public static int getRowCount()
	{
		return sheet.getPhysicalNumberOfRows();
	}
	
	public static int getRowCount(String sheetName)
	{
		sheet = workbook.getSheet(sheetName);
		return sheet.getPhysicalNumberOfRows();
	}
	
	public static int getColumnCount()
	{
		return sheet.getRow(0).getPhysicalNumberOfCells();
	}
	
	public static int getColumnCount(String sheetName)
	{
		sheet = workbook.getSheet(sheetName);
		return sheet.getRow(0).getPhysicalNumberOfCells();
	}
	
	// Read Excel file and return data as object 2 dimensional array
	public Object[][] readExcelTestData(String filePath, String fileName, String sheetName) 
	{
		Object[][] excelTestData = null;

		try 
		{
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
	
			for (int i = 1; i < rowCount; i++) 
			{
				row = sheet.getRow(i);
	
				for (int j = 0; j < colCount; j++) 
				{
					if (row == null) 
					{
						excelTestData[i][j] = "";
					} 
					else 
					{
						cell = row.getCell(j);
	
						if (cell == null) 
						{
							excelTestData[i][j] = "";
						} 
						else 
						{
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
	
	
	//reads the excel data and returns data as Linked List. Iterator is used. It cannot recognize blank and empty cells.
	public List<List<Cell>> readExcelData(String filePath, String fileName, String sheetName) 
	{
		List<List<Cell>> rowData = new ArrayList<>();
		
		try 
		{
			File file = new File(filePath + "/" + fileName);
			FileInputStream fileInputStream = new FileInputStream(file);

			String fileExtention = fileName.substring(fileName.indexOf("."));

			if (fileExtention.equalsIgnoreCase(".xlsx")) 
			{
				workbook = new XSSFWorkbook(fileInputStream);
			} 
			else if (fileExtention.equalsIgnoreCase(".xls"))
			{
				workbook = new HSSFWorkbook(fileInputStream);
			}

			Sheet sheet = workbook.getSheet(sheetName);

			if (sheet == null) 
			{
				throw new IllegalArgumentException("No sheet exists with name: " + sheetName);
			}
			
			Iterator<Row> rows = sheet.rowIterator();
			
			while(rows.hasNext())
			{
				row = rows.next();
				
				Iterator<Cell> cells = row.cellIterator();
				
				List<Cell> cellData = new ArrayList<>();
				
				while(cells.hasNext())
				{
					cell = cells.next();
					cellData.add(cell);
				}
				rowData.add(cellData);
			}
			
		}
		catch(FileNotFoundException fne)
		{
			log.error("Test Excel file not found or Path not found");
		}
		catch(IOException ioe)
		{
			log.error("Test Excel file not readable");
		}
		
		return rowData;
	}
	
	//prints Linked List of Excel Data
	public void printExcelData(List<List<Cell>> rowData)
	{
		for(List<Cell> row : rowData)
		{
			for(Cell cell : row)
			{
				System.out.print(cell + "\t");
			}
			System.out.println("");
		}
	}
	
	
	//Read Test Suite Multiple Sheet data, Test Suite and Test case are in single excel. Reads row by row
	public Object[][] readExcelTestSuite(String filePath, String fileName, String testSuiteSheetName, String testCaseSheetName) 
	{
		Object[][] excelTestSuite = null;
		Object[][] excelTestCases = null;

		try 
		{
			File file = new File(filePath + "/" + fileName);
			FileInputStream fileInputStream = new FileInputStream(file);
	
			String fileExtention = fileName.substring(fileName.indexOf("."));
	
			if (fileExtention.equalsIgnoreCase(".xlsx")) {
				workbook = new XSSFWorkbook(fileInputStream);
			} else if (fileExtention.equalsIgnoreCase(".xls")) {
				workbook = new HSSFWorkbook(fileInputStream);
			}
	
			Sheet sheet = workbook.getSheet(testSuiteSheetName);
	
			if (sheet == null) 
			{
				throw new IllegalArgumentException("No sheet exists with name " + testSuiteSheetName);
			}
	
			int rowCount = sheet.getPhysicalNumberOfRows();
			int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
			
			excelTestSuite = new Object[rowCount - 1][colCount];
	
			for (int i = 1; i < rowCount; i++) 
			{
				ts_Row = sheet.getRow(i); //Test Suite Excel Row
	
				for (int j = 0; j < colCount; j++) 
				{
					if (ts_Row == null) 
					{
						excelTestSuite[i][j] = "";
					} 
					else 
					{
						ts_Cell = ts_Row.getCell(j); //Test Suite Excel Cell
	
						if (ts_Cell == null) 
						{
							excelTestSuite[i][j] = "";
						} 
						else 
						{
							String cellString = formatter.formatCellValue(ts_Cell);
							excelTestSuite[i - 1][j] = cellString;
							System.out.print(cellString + "\t");
						}
						
					}
					
				}
				//If execution mode is YES. Iterate to Test Case sheet to get the data
				if(ts_Row.getCell(Propertie.Col_Execution).getStringCellValue().equalsIgnoreCase("YES"))
				{
					String tc_SheetName = ts_Row.getCell(Propertie.Col_TestCaseSheetName).getStringCellValue();
					
					Sheet tc_Sheet = workbook.getSheet(tc_SheetName);
					System.out.println("Sheet Name: " + tc_SheetName);
					System.out.println("tc_sheet:" + tc_Sheet);
					int tc_RowCount = tc_Sheet.getPhysicalNumberOfRows();
					int tc_ColumnCount = tc_Sheet.getRow(0).getPhysicalNumberOfCells();
					
					excelTestCases = new Object[tc_RowCount][tc_ColumnCount];
					
					
					for(int k = 0; k < tc_RowCount; k++)
					{
						tc_Row = tc_Sheet.getRow(k);
						
						//Checking Test Suite Test CaseID and Test Case Sheet Test Case ID are equal to continue reading the test case data other wise skip it.
						if(ts_Row.getCell(Propertie.Col_TestCaseID).getStringCellValue().equalsIgnoreCase(tc_Row.getCell(Propertie.Col_TestCaseID).getStringCellValue()))
						{
							for(int l = 0; l < tc_ColumnCount; l++)
							{
								if(tc_Row == null)
								{
									excelTestCases[k][l] = "";
								}
								else
								{
									tc_Cell = tc_Row.getCell(l);
									
									if(tc_Cell == null)
									{
										excelTestCases[k][l] = "";
									}
									else
									{
										String tc_CellData = formatter.formatCellValue(tc_Cell);
										excelTestCases[k][l] = tc_CellData;
										System.out.print(tc_CellData + "\t");
									}
								}
								
							}
							System.out.println("");
						}
					}
				}
			
			System.out.println("");

		}
	
			workbook.close();
			fileInputStream.close();
	
			// printing the excel test data object array
			/*for (int i = 0; i < excelTestSuite.length; i++) 
			{
				for (int j = 0; j < excelTestSuite[i].length; j++) 
				{
					System.out.print(excelTestSuite[i][j] + "\t");
				}
				System.out.println("");
			}*/
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	
		return excelTestSuite; // returns excel Suite data
		}
	
	
	
	public static void main(String[] args)
	{
		ExcelUtil excel = new ExcelUtil();
		
//		List<List<Cell>> excelData = excel.readExcelData(Propertie.testExcel_filePath, Propertie.testExcel_FileName, Propertie.testExcel_TestSuite_SheetName);
//		excel.printExcelData(excelData);
		
		excel.readExcelTestSuite(Propertie.testExcel_filePath, Propertie.testExcel_FileName, Propertie.testExcel_TestSuite_SheetName, Propertie.testExcel_TestCase_sheetName);
	}
}
