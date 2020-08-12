package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
 * This Excel Utility class has a methods to read excel, write excel data.
 */
public class ExcelUtil 
{
	Workbook workbook;
	DataFormatter formatter = new DataFormatter();
	Workbook wb;
	Sheet sheet;
	Row row;
	Cell cell;
	String filePath;
	String fileName;
	Workbook workbookStatic;
	DataFormatter formatterStatic = new DataFormatter();
	
	
	//String filePath = Propertie.testData_filePath;
	//String fileName = Propertie.testData_FileName;
	//String sheetName = Propertie.testData_sheetName;
	
	//Sets the excel filePath, fileName, SheetName
	public void setExcelFile(String filePath, String fileName, String sheetName)
	{
		this.filePath = filePath;
		this.fileName = fileName;
		
		try
		{
			File file = new File(filePath + "/" + fileName);
			FileInputStream fileInputStream = new FileInputStream(file);
			
			String fileExtention = fileName.substring(fileName.indexOf("."));
		
			if (fileExtention.equalsIgnoreCase(".xlsx"))
			{
				 wb = new XSSFWorkbook(fileInputStream);
			}
			else if(fileExtention.equalsIgnoreCase(".xls"))
			{
				 wb = new HSSFWorkbook(fileInputStream);
			}
						
		    sheet = wb.getSheet(sheetName);
			
			if (sheet == null) 
			{
				   throw new IllegalArgumentException("No sheet exists with name " + sheetName);
			}
			System.out.println(sheet);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	
	
	public void readExcelFile()
	{
		try
		{
			//FileInputStream file = new FileInputStream(new File("/Users/rajak/git/repository/SAPPlatformTest/src/resources/TestData.xlsx"));
			FileInputStream file = new FileInputStream(new File(Propertie.testData_filePath + Propertie.testData_FileName));
			
			XSSFWorkbook wb = new XSSFWorkbook(file);
			
			XSSFSheet sheet = wb.getSheetAt(0);
			
			Iterator<Row> rowIterator = sheet.iterator();
			
			while(rowIterator.hasNext())
			{
				Row row = rowIterator.next();
				
				Iterator<Cell> cellIterator = row.cellIterator();
				
				while(cellIterator.hasNext())
				{
					Cell cell = cellIterator.next();
					
					switch(cell.getCellType())
					{
						case NUMERIC:
							System.out.print(cell.getNumericCellValue() + "\t");
							break;
						case STRING:
							System.out.print(cell.getStringCellValue() + "\t");
							break;
						case BOOLEAN:
							System.out.print(cell.getBooleanCellValue() + "\t");
							break;
						case FORMULA:
							System.out.print(cell.getCellFormula() + "\t");
							break;
						case _NONE:
							System.out.print(cell.getStringCellValue() + "\t");
							break;
						case BLANK:
							System.out.print(cell.getStringCellValue() + "\t");
							break;
						case ERROR:	
							System.out.print(cell.getErrorCellValue() + "\t");
							break;
					}
					
				}
				System.out.println("");
			}
			wb.close();
			file.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
	
	//Read Excel file and return data as object
	public Object[][] readExcelTestData(String filePath, String fileName, String sheetName) 
	{
		Object[][] excelTestData = null;
		
		try
		{
			File file = new File(filePath + "/" + fileName);
			FileInputStream fileInputStream = new FileInputStream(file);
			
			String fileExtention = fileName.substring(fileName.indexOf("."));
			
			if (fileExtention.equalsIgnoreCase(".xlsx"))
			{
				 workbookStatic = new XSSFWorkbook(fileInputStream);
			}
			else if(fileExtention.equalsIgnoreCase(".xls"))
			{
				 workbookStatic = new HSSFWorkbook(fileInputStream);
			}
						
			Sheet sheet = workbookStatic.getSheet(sheetName);
			
			if (sheet == null) 
			{
				   throw new IllegalArgumentException("No sheet exists with name " + sheetName);
			}
			
			int rowCount = sheet.getPhysicalNumberOfRows();
			int rowCount1 = sheet.getLastRowNum()-sheet.getFirstRowNum();
			int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
			
			System.out.println(rowCount + "-"+ rowCount1 + "-" + colCount);
			
			excelTestData = new Object[rowCount-1][colCount];
			
			for(int i = 1; i < rowCount; i++)
			{
				Row row = sheet.getRow(i);
				
				for(int j = 0; j < colCount; j++)
				{
					if(row == null)
					{
						excelTestData[i][j] = "";
					}
					else
					{
						Cell cell = row.getCell(j);
						
						if(cell == null)
						{
							excelTestData[i][j] = "";
						}
						else
						{
							String cellString = formatterStatic.formatCellValue(cell);
							excelTestData[i-1][j] = cellString;	
						}
						
					}
				}
					
			}

			workbookStatic.close();
			fileInputStream.close();
			
			//printing the excel test data object array
			for(int i = 0; i < excelTestData.length; i++)
			{
				for(int j = 0; j< excelTestData[i].length; j++)
				{
					System.out.print(excelTestData[i][j] + "\t");
				}
				System.out.println("");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return excelTestData; //returns excel data
	}
	
	
	public void readExcelFile(String filePath, String fileName, String sheetName) 
	{
		
		try
		{
			File file = new File(filePath + "/" + fileName);
			FileInputStream fileInputStream = new FileInputStream(file);
			
			String fileExtention = fileName.substring(fileName.indexOf("."));
			
			if (fileExtention.equalsIgnoreCase(".xlsx"))
			{
				 workbook = new XSSFWorkbook(fileInputStream);
			}
			else if(fileExtention.equalsIgnoreCase(".xls"))
			{
				 workbook = new HSSFWorkbook(fileInputStream);
			}
						
			Sheet sheet = workbook.getSheet(sheetName);
			
			if (sheet == null) 
			{
				   throw new IllegalArgumentException("No sheet exists with name " + sheetName);
			}
				   
			
			int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
			
			for(int i = 0; i < rowCount + 1; i++)
			{
				Row row = sheet.getRow(i);
				
				for(int j = 0; j < row.getLastCellNum(); j++)
				{
					System.out.print(formatter.formatCellValue(sheet.getRow(i).getCell(j)) + "\t");
				}
				
				System.out.println();
			}
			
			workbook.close();
			fileInputStream.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public String getCellData(String sheetName, int rowNum, int colNum)
	{
		
			Cell cell = sheet.getRow(rowNum).getCell(colNum);
			
			String cellData = cell.getStringCellValue();
			
			return cellData;
	}
	
	public int getRowCount(String sheetName)
	{
		return sheet.getPhysicalNumberOfRows();
	}
	
	public int getColumnCount(String sheetName, int rowNum)
	{
		return sheet.getRow(rowNum).getPhysicalNumberOfCells();
	}
	
	public void setCellData(String result, int rowNum, int colNum) throws FileNotFoundException
	{
		
		try 
		{
			
		 row = sheet.createRow(rowNum);
		 cell = row.createCell(colNum);
		 cell.setCellValue(result);
		 
		 System.out.println("I am here " + sheet.getRow(rowNum).getCell(colNum).getStringCellValue());
		
		/*if(cell == null)
		{
			cell = row.createCell(colNum);
			cell.setCellValue(result);
		}
		else
		{
			cell.setCellValue(result);
		}*/
		
		System.out.println(filePath+fileName);
		//wb = new XSSFWorkbook();
		
		FileOutputStream fileOut = new FileOutputStream(new File(filePath + fileName));
		
		wb.write(fileOut);
			
			wb.close();
			fileOut.close();
			
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	
	public void writeExcelfile(String filePath, String fileName, String sheetName, String[] dataToWrite)
	{
		try
		{
			File file = new File(filePath + "/" + fileName);
			
			FileInputStream inputStream = new FileInputStream(file);
			
			if(fileName.substring(fileName.indexOf(".")).equalsIgnoreCase(".xlsx"))
			{
				workbook = new XSSFWorkbook(inputStream);
			}
			else if(fileName.substring(fileName.indexOf(".")).equalsIgnoreCase(".xls"))
			{
				workbook = new HSSFWorkbook(inputStream);
			}
			
			Sheet sheet = workbook.getSheet(sheetName);
			
			if (sheet == null) 
			{
				   throw new IllegalArgumentException("No sheet exists with name " + sheetName);
			}
			
			int rowCount = sheet.getLastRowNum() - sheet.getLastRowNum();
			
			for(int i = 0; i < rowCount; i++)
			{
				Row row = sheet.getRow(i);
				
				for(int j = 0; j< row.getLastCellNum(); j++ )
				{
					Cell cell = row.createCell(j);
					cell.setCellValue(dataToWrite[j]);
				}
			}
			
			inputStream.close();
			
			FileOutputStream outputStream = new FileOutputStream(file);
			workbook.write(outputStream);
			outputStream.close();
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) throws FileNotFoundException
	{
		ExcelUtil excel = new ExcelUtil();
		//String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
		//excel.readExcelFile("/Users/rajak/git/repository/SAPPlatformTest/src/resources/", "Math.xlsx", "");
		//excel.writeExcelfile("/Users/rajak/Downloads/", "TestWrite.xlsx", "Sheet1", cars );
		//excel.setExcelFile("/Users/rajak/Downloads/", "TestWrite.xlsx", "Sheet1");
		excel.readExcelTestData("/Users/rajak/git/repository/SAPPlatformTest/src/resources/", "TestData.xlsx", "Sheet1");
		//System.out.println(excel.getCellData("Sheet1", 1, 1));
		//excel.setCellData("RAMP", 5, 5);
		//excel.setCellData("DR", 6, 5);
		//System.out.println(excel.getCellData("Sheet1", 5, 5));
	}
}
